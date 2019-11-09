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

import br.com.fatesg.fabrica.projetofabrica.repositorio.Solicitacao;
import br.com.fatesg.fabrica.projetofabrica.servico.SolicitacaoNeg;
@Qualifier
@RestController
@RequestMapping(value="/api/solicitacoes", path="/api/solicitacoes")
public class SolicitacaoResource {
		
	@Autowired
	private SolicitacaoNeg solicitacaoNeg;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Solicitacao> getSolicitacoes() {
		return solicitacaoNeg.findAll();
	}
	
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Solicitacao> getSolicitacoesById(@PathParam(value = "id") Long id) {
		return new ArrayList<Solicitacao>();
	}
}
