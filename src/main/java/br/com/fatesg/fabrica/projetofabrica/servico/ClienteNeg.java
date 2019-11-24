package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.Cliente;
import br.com.fatesg.fabrica.projetofabrica.repositorio.ClienteRepository;

@Service
public class ClienteNeg {
	
	@Autowired
	public ClienteRepository repository;
	
	public Cliente findById(Integer id){
    	return repository.findById(id);
    }
    
    public Cliente findByIdOrderByNome(Long id) {
    	return repository.getOne(id);
    }
    
    public List<Cliente> findByClientesOrderByNome(String nome){
    	return null;
    }
    
    public List<Cliente> findAll() {
    	return repository.findAll();
    }   


	public Cliente save(Cliente obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);
	
	}
	
	public void remover(Cliente cliente) {
		repository.delete(cliente);
	
	}
}
