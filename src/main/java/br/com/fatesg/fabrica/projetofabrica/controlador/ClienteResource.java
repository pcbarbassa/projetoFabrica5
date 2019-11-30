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
import br.com.fatesg.fabrica.projetofabrica.servico.ClienteNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/clientes", path="/api/clientes")
public class ClienteResource {
		
	@Autowired
	private ClienteNeg negocio;

	@GetMapping
	public List<Cliente> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable int id) {
		Cliente cliente = negocio.findById(id);
		
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(cliente);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable int id, 
			@Valid @RequestBody Cliente cliente) {
		Cliente clienteExistente = negocio.findById(id);
		
		if (clienteExistente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(cliente, clienteExistente, "id");
		
		clienteExistente = negocio.save(clienteExistente);
		
		return ResponseEntity.ok(clienteExistente);
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente objeto){
	   
		Cliente existente = negocio.findByCpfCnpj(objeto.getCpfCnpj());
		
		if (existente == null) {
			existente = negocio.findByEmail(objeto.getEmail());
		}
		
		if (existente == null) {
			negocio.save(objeto);
			return ResponseEntity.ok(objeto);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(existente);			
		}			
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        
		Cliente cliente = negocio.findById(id);
		
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		negocio.remover(cliente);	
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
