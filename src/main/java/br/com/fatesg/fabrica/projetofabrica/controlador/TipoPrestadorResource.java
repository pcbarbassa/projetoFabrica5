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

import br.com.fatesg.fabrica.projetofabrica.TipoPrestador;
import br.com.fatesg.fabrica.projetofabrica.servico.TipoPrestadorNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/tipoprestadores", path="/api/tipoprestadores")
public class TipoPrestadorResource {
		
	@Autowired
	private TipoPrestadorNeg negocio;

	@GetMapping
	public List<TipoPrestador> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoPrestador> buscar(@PathVariable int id) {
		TipoPrestador obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoPrestador> atualizar(@PathVariable int id, 
			@Valid @RequestBody TipoPrestador obj) {
		TipoPrestador existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(obj, existente, "id");		
		existente = negocio.save(existente);		
		return ResponseEntity.ok(existente);		
	}
	
	@PostMapping
	public ResponseEntity<TipoPrestador> criar(@Valid @RequestBody TipoPrestador objeto){
		   
		TipoPrestador existente = negocio.findByDescricao(objeto.getDescricao());
			
			if (existente == null) {
				negocio.save(objeto);
				return ResponseEntity.ok(objeto);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(existente);
				
			}		
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		TipoPrestador obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		negocio.remover(obj);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
