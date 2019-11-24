package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.StatusServico;
import br.com.fatesg.fabrica.projetofabrica.repositorio.StatusServicoRepository;

@Service
public class StatusServicoNeg {
	
	@Autowired
	public StatusServicoRepository repository;
	
	public StatusServico findById(Integer id){
    	return repository.findById(id);
    }
    
    public StatusServico findDescricaoById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<StatusServico> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<StatusServico> findAll() {
    	return repository.findAll();
    }   

	public StatusServico save(StatusServico obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);	
	}
	
	public void remover(StatusServico obj) {
		repository.delete(obj);	
	}
}
