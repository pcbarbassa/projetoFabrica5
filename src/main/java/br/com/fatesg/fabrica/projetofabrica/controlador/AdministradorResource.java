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

import br.com.fatesg.fabrica.projetofabrica.Administrador;
import br.com.fatesg.fabrica.projetofabrica.servico.AdministradorNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/administradores", path="/api/administradores")
public class AdministradorResource {
		
	@Autowired
	private AdministradorNeg negocio;

	@GetMapping
	public List<Administrador> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Administrador> buscar(@PathVariable int id) {
		Administrador administrador = negocio.findById(id);
		
		if (administrador == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(administrador);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Administrador> atualizar(@RequestBody int id, 
			@RequestBody Administrador administrador) {
		Administrador existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(administrador, existente, "id");
		
		existente = negocio.save(existente);
		
		return ResponseEntity.ok(existente);
		
	}
	
	@PostMapping
	public Administrador criar(@Valid @RequestBody Administrador administrador){
	   return negocio.save(administrador);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		Administrador administrador = negocio.findById(id);
		
		if (administrador == null) {
			return ResponseEntity.notFound().build();
		}
		
		negocio.remover(administrador);
	
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
