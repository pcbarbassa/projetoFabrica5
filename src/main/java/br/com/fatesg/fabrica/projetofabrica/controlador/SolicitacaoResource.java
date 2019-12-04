package br.com.fatesg.fabrica.projetofabrica.controlador;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	public ResponseEntity<List<Solicitacao>> buscar(@PathVariable int id) {
		List<Solicitacao> obj = negocio.findAllOrderByStatusSolicitacao_Id(id);		
		if (obj == null || obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<List<Solicitacao>> buscarPorCliente(@PathVariable int id) {
		List<Solicitacao> obj = negocio.findByCliente_Id(id);		
		if (obj == null || obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping("/statussolicitacao/{id}")
	public ResponseEntity<List<Solicitacao>> buscarPorStatus(@PathVariable int id) {
		List<Solicitacao> obj = negocio.findByStatusSolicitacao_Id(id);		
		if (obj == null || obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping("/tipoprestador/{id}")
	public ResponseEntity<List<Solicitacao>> buscarTipoPrestador(@PathVariable int id) {
		List<Solicitacao> obj = negocio.findByTipoPrestador_Id(id);		
		if (obj == null || obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping("/tipoPrestadorId/{tipoPrestadorId}/statusSolicitacaoId/{statusSolicitacaoId}")
	public ResponseEntity<List<Solicitacao>> buscarTipoPrestadorEStatusSolicitacao(@PathVariable Integer tipoPrestadorId, 
			@PathVariable Integer statusSolicitacaoId) {
		List<Solicitacao> obj = negocio.findByTipoPrestador_IdAndStatusSolicitacao_Id(tipoPrestadorId,statusSolicitacaoId);		
		if (obj == null || obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping("/statusSolicitacaoId/{statusSolicitacaoId}/tipoPrestadorId/{tipoPrestadorid}")
	public ResponseEntity<List<Solicitacao>> buscarStatusSolicitacaoETipoPrestador(@PathVariable Integer statusSolicitacaoId, 
			@PathVariable Integer tipoPrestadorId) {
		List<Solicitacao> obj = negocio.findByStatusSolicitacao_IdAndTipoPrestador_Id(statusSolicitacaoId,tipoPrestadorId);		
		if (obj == null || obj.isEmpty()) {
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
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarParcial(@PathVariable int id, 
			@RequestBody Map<String, Object> body) {
		
		Solicitacao existente = negocio.findById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(body, existente, "id");		
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