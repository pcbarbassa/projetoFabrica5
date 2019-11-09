package br.com.fatesg.fabrica.projetofabrica.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.fabrica.projetofabrica.repositorio.Cliente;
import br.com.fatesg.fabrica.projetofabrica.servico.ClienteNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/clientes", path="/api/clientes")
public class ClienteResource {
		
	@Autowired
	private ClienteNeg clienteNeg;

	@GetMapping(produces= { MediaType.APPLICATION_XML_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	public List<Cliente> getClientes() {
		return clienteNeg.findAll();
	}
	
	@GetMapping(path="/{id}", produces= { MediaType.APPLICATION_XML_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	public List<Cliente> getClientesById(@PathParam(value = "id") Long id) {
		return new ArrayList<Cliente>();
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente){
	   return clienteNeg.save(cliente);
	}

	@DeleteMapping(path="/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
