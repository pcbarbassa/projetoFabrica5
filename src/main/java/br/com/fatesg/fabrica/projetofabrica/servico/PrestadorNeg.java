package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.Cliente;
import br.com.fatesg.fabrica.projetofabrica.Prestador;
import br.com.fatesg.fabrica.projetofabrica.repositorio.PrestadorRepository;

@Service
public class PrestadorNeg {
	
	@Autowired
	public PrestadorRepository repository;
	
	public Prestador findById(int id){
    	return repository.findById(id);
    }
    
    public Prestador findPrestador(Long id) {
    	return repository.getOne(id);
    }
    
    public List<Prestador> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<Prestador> findAll() {
    	return repository.findAll();
    }
    
	public Prestador save(Prestador obj) {
		repository.save(obj);
		return obj;
	}
		
	public void deleteById(long id) {
		repository.deleteById(id);
	
	}
	
	public void delete(Prestador obj) {
		repository.delete(obj);
	
	}
}
