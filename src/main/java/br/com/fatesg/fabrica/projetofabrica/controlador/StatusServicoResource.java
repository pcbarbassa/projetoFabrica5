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

import br.com.fatesg.fabrica.projetofabrica.StatusServico;
import br.com.fatesg.fabrica.projetofabrica.servico.StatusServicoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/statusservico", path="/api/statusservico")
public class StatusServicoResource {
		
	@Autowired
	private StatusServicoNeg negocio;

	@GetMapping
	public List<StatusServico> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusServico> buscar(@PathVariable int id) {
		StatusServico obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusServico> atualizar(@PathVariable int id, 
			@Valid @RequestBody StatusServico obj) {
		StatusServico existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(obj, existente, "id");		
		existente = negocio.save(existente);		
		return ResponseEntity.ok(existente);		
	}
	
	@PostMapping
	public StatusServico criar(@Valid @RequestBody StatusServico objeto){
	   return negocio.save(objeto);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		StatusServico obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		negocio.remover(obj);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
