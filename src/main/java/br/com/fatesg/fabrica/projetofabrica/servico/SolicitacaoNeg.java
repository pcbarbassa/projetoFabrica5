package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.Solicitacao;
import br.com.fatesg.fabrica.projetofabrica.repositorio.SolicitacaoRepository;

@Service
public class SolicitacaoNeg {
	
	@Autowired
	public SolicitacaoRepository repository;
	
	public Solicitacao findById(Integer id){
    	return repository.findById(id);
    }
	
	public List<Solicitacao> findAllOrderByStatusSolicitacao_Id(Integer id){
    	return repository.findAllOrderByStatusSolicitacao_Id(id);
    }
    
    public Solicitacao findDescricaoById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<Solicitacao> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<Solicitacao> findAll() {
    	return repository.findAll();
    }   
    
    public List<Solicitacao> findByCliente_Id(Integer id) {
    	return repository.findByCliente_Id(id);
    }  

	public Solicitacao save(Solicitacao obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);	
	}
	
	public void remover(Solicitacao obj) {
		repository.delete(obj);	
	}

	public List<Solicitacao> findByTipoPrestador_Id(Integer id) {
		return repository.findByTipoPrestador_Id(id);
	}

	public List<Solicitacao> findByStatusSolicitacao_Id(int id) {
		return repository.findByStatusSolicitacao_Id(id);
	}
}

