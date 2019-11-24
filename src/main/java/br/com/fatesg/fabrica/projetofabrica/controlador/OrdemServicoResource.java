package br.com.fatesg.fabrica.projetofabrica.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.fabrica.projetofabrica.OrdemServico;
import br.com.fatesg.fabrica.projetofabrica.servico.OrdemServicoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/ordensservicos", path="/api/ordensservicos")
public class OrdemServicoResource {
		
	@Autowired
	private OrdemServicoNeg negocio;

	@GetMapping
	public List<OrdemServico> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServico> buscar(@PathVariable int id) {
		OrdemServico obj = negocio.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(obj);
		
	}
	
	@GetMapping("/prestador/{id}")
	public ResponseEntity<List<OrdemServico>> buscarPorPrestador(@PathVariable long id) {
		List<OrdemServico> obj = negocio.findByPrestador_Id(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(obj);
		
	}
	
	@GetMapping("/solicitacao/cliente/{id}")
	public ResponseEntity<List<OrdemServico>> buscarPorCliente(@PathVariable long id) {
		List<OrdemServico> obj = negocio.findBySolicitacao_Cliente_Id(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(obj);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable int id, 
			@Valid @RequestBody OrdemServico obj) {
		OrdemServico existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(obj, existente, "id");
		
		existente = negocio.save(existente);
		
		return ResponseEntity.ok(existente);
		
	}
	
	@PostMapping
	public OrdemServico criar(@Valid @RequestBody OrdemServico obj){
	   return negocio.save(obj);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		OrdemServico obj = negocio.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		negocio.remover(obj);
	
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
