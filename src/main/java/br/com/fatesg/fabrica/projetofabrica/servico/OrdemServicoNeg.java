package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.OrdemServico;
import br.com.fatesg.fabrica.projetofabrica.repositorio.OrdemServicoRepository;

@Service
public class OrdemServicoNeg {
	
	@Autowired
	public OrdemServicoRepository repository;
	
	public OrdemServico findById(int id){
    	return repository.findById(id);
    }
    
    public OrdemServico findDescricaoById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<OrdemServico> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<OrdemServico> findAll() {
    	return repository.findAll();
    }   
    
    public List<OrdemServico> findByPrestador_Id(Long id) {
    	return repository.findByPrestador_Id(id);
    }
    
    public List<OrdemServico> findBySolicitacao_Cliente_Id(Long id) {
    	return repository.findBySolicitacao_Cliente_Id(id);
    }    

	public OrdemServico save(OrdemServico obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);
	
	}
	
	public void remover(OrdemServico obj) {
		repository.delete(obj);
	
	}
}
