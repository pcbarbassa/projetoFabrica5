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

import br.com.fatesg.fabrica.projetofabrica.Prestador;
import br.com.fatesg.fabrica.projetofabrica.TipoPrestador;
import br.com.fatesg.fabrica.projetofabrica.servico.PrestadorNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/prestadores", path="/api/prestadores")
public class PrestadorResource {
		
	@Autowired
	private PrestadorNeg prestadorNeg;

	@GetMapping
	public List<Prestador> listar() {
		return prestadorNeg.findAll();
	}
	
	@GetMapping("/count")
	public long count() {
		return prestadorNeg.count();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prestador> buscar(@PathVariable long id) {
		Prestador prestador = prestadorNeg.findById(id);
		
		if (prestador == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(prestador);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prestador> atualizar(@PathVariable int id, 
			@RequestBody Prestador prestador) {
		Prestador obj = prestadorNeg.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(prestador, obj, "id");
		
		obj = prestadorNeg.save(obj);
		
		return ResponseEntity.ok(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Prestador> criar(@Valid @RequestBody Prestador objeto){
		   
		Prestador existente = prestadorNeg.findByCpfCnpj(objeto.getCpfCnpj());
			
			if (existente == null) {
				prestadorNeg.save(objeto);
				return ResponseEntity.ok(objeto);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(existente);
				
			}		
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		Prestador obj = prestadorNeg.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		prestadorNeg.delete(obj);
	
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping("/cadastrarPrestador")
	public String form() {
		return "contrato/formPrestador";
	}
}
