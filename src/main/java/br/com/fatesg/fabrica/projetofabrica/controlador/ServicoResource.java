package br.com.fatesg.fabrica.projetofabrica.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatesg.fabrica.projetofabrica.Servico;
import br.com.fatesg.fabrica.projetofabrica.servico.ServicoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/servicos", path="/api/servicos")
public class ServicoResource {
		
	@Autowired
	private ServicoNeg servicoNeg;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Servico> getServicos() {
		return servicoNeg.findAll();
	}
	
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Servico> getServicosById(@PathParam(value = "id") Long id) {
		return new ArrayList<Servico>();
	}
}
