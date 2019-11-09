package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.repositorio.Solicitacao;
import br.com.fatesg.fabrica.projetofabrica.repositorio.SolicitacaoRepository;

@Service
public class SolicitacaoNeg {
	
	@Autowired
	public SolicitacaoRepository solicitacaoRepository;
	
	public List<Solicitacao> findById(int id){
    	return solicitacaoRepository.findById(id);
    }
    
    public Solicitacao findDescricaoById(Long id) {
    	return solicitacaoRepository.getOne(id);
    }
    
    public List<Solicitacao> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<Solicitacao> findAll() {
    	return solicitacaoRepository.findAll();
    }

}
