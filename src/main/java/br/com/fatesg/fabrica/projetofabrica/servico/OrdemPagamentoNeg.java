package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.OrdemPagamento;
import br.com.fatesg.fabrica.projetofabrica.repositorio.OrdemPagamentoRepository;

@Service
public class OrdemPagamentoNeg {
	
	@Autowired
	public OrdemPagamentoRepository repository;
	
	public OrdemPagamento findById(int id){
    	return repository.findById(id);
    }
    
    public OrdemPagamento findDescricaoById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<OrdemPagamento> findByIdOrderByData(String descricao){
    	return null;
    }
    
    public List<OrdemPagamento> findAll() {
    	return repository.findAll();
    }   


	public OrdemPagamento save(OrdemPagamento obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);
	
	}
	
	public void remover(OrdemPagamento obj) {
		repository.delete(obj);
	
	}
}
