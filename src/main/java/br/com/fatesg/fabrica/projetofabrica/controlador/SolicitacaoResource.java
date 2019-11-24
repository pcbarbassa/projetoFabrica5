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

import br.com.fatesg.fabrica.projetofabrica.Solicitacao;
import br.com.fatesg.fabrica.projetofabrica.servico.SolicitacaoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/solicitacoes", path="/api/solicitacoes")
public class SolicitacaoResource {
		
	@Autowired
	private SolicitacaoNeg negocio;

	@GetMapping
	public List<Solicitacao> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Solicitacao> buscar(@PathVariable int id) {
		Solicitacao obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<List<Solicitacao>> buscarPorCliente(@PathVariable long id) {
		List<Solicitacao> obj = negocio.findByCliente_Id(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Solicitacao> atualizar(@PathVariable int id, 
			@Valid @RequestBody Solicitacao obj) {
		Solicitacao existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(obj, existente, "id");		
		existente = negocio.save(existente);		
		return ResponseEntity.ok(existente);		
	}
	
	@PostMapping
	public Solicitacao criar(@Valid @RequestBody Solicitacao objeto){
	   return negocio.save(objeto);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		Solicitacao obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		negocio.remover(obj);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}