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

import br.com.fatesg.fabrica.projetofabrica.OrdemPagamento;
import br.com.fatesg.fabrica.projetofabrica.servico.OrdemPagamentoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/ordempagamento", path="/api/ordempagamento")
public class OrdemPagamentoResource {
		
	@Autowired
	private OrdemPagamentoNeg negocio;

	@GetMapping
	public List<OrdemPagamento> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemPagamento> buscar(@PathVariable long id) {
		OrdemPagamento obj = negocio.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(obj);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrdemPagamento> atualizar(@PathVariable int id, 
			@Valid @RequestBody OrdemPagamento obj) {
		OrdemPagamento existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(obj, existente, "id");
		
		existente = negocio.save(existente);
		
		return ResponseEntity.ok(existente);
		
	}
	
	@PostMapping
	public OrdemPagamento criar(@Valid @RequestBody OrdemPagamento obj){
	   return negocio.save(obj);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		OrdemPagamento obj = negocio.findById(id);
		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		negocio.remover(obj);
	
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
