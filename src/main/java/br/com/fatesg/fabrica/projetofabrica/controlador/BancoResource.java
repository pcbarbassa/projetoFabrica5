package br.com.fatesg.fabrica.projetofabrica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.fabrica.projetofabrica.Banco;
import br.com.fatesg.fabrica.projetofabrica.servico.BancoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/bancos", path="/api/bancos")
public class BancoResource {
		
	@Autowired
	private BancoNeg negocio;

	@GetMapping
	public List<Banco> listar() {
		return negocio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Banco> buscar(@PathVariable int id) {
		Banco obj = negocio.findById(id);		
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
}
