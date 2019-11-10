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

import br.com.fatesg.fabrica.projetofabrica.Cliente;
import br.com.fatesg.fabrica.projetofabrica.Prestador;
import br.com.fatesg.fabrica.projetofabrica.servico.PrestadorNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/prestadores", path="/api/prestadores")
public class PrestadorResource {
		
	@Autowired
	private PrestadorNeg negocio;

	@GetMapping
	public List<Prestador> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prestador> buscar(@PathVariable int id) {
		Prestador prestador = negocio.findById(id);
		
		if (prestador == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(prestador);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prestador> atualizar(@PathVariable int id, 
			@Valid @RequestBody Cliente cliente) {
		Prestador obj = negocio.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(cliente, obj, "id");
		
		obj = negocio.save(obj);
		
		return ResponseEntity.ok(obj);
		
	}
	
	@PostMapping
	public Prestador criar(@Valid @RequestBody Prestador obj){
	   return negocio.save(obj);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		Prestador obj = negocio.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		negocio.delete(obj);
	
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
