package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.TipoPrestador;
import br.com.fatesg.fabrica.projetofabrica.repositorio.TipoPrestadorRepository;

@Service
public class TipoPrestadorNeg {
	
	@Autowired
	public TipoPrestadorRepository repository;
	
	public TipoPrestador findById(Integer id){
    	return repository.findById(id);
    }
    
    public TipoPrestador findDescricaoById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<TipoPrestador> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<TipoPrestador> findAll() {
    	return repository.findAll();
    }   

	public TipoPrestador save(TipoPrestador obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);	
	}
	
	public void remover(TipoPrestador obj) {
		repository.delete(obj);	
	}

	public TipoPrestador findByDescricao(String descricao) {
		return repository.findByDescricao(descricao);
	}

	public List<TipoPrestador> findByAtivoTrue() {
		return repository.findByAtivoTrue();
	}
}
