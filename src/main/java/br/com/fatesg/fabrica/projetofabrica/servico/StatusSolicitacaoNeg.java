package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.StatusSolicitacao;
import br.com.fatesg.fabrica.projetofabrica.repositorio.StatusSolicitacaoRepository;

@Service
public class StatusSolicitacaoNeg {
	
	@Autowired
	public StatusSolicitacaoRepository repository;
	
	public StatusSolicitacao findById(int id){
    	return repository.findById(id);
    }
    
    public StatusSolicitacao findDescricaoById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<StatusSolicitacao> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<StatusSolicitacao> findAll() {
    	return repository.findAll();
    }   

	public StatusSolicitacao save(StatusSolicitacao obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);	
	}
	
	public void remover(StatusSolicitacao obj) {
		repository.delete(obj);	
	}
}
