package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.Endereco;
import br.com.fatesg.fabrica.projetofabrica.repositorio.EnderecoRepository;

@Service
public class EnderecoNeg {
	
	@Autowired
	public EnderecoRepository repository;
	
	public Endereco findById(int id){
    	return repository.findById(id);
    }
    
    public Endereco findCepById(Long id) {
    	return repository.getOne(id);
    }
    
    public List<Endereco> findByIdOrderByCep(String cep){
    	return null;
    }
    
    public List<Endereco> findAll() {
    	return repository.findAll();
    }   

	public Endereco save(Endereco obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);	
	}
	
	public void remover(Endereco obj) {
		repository.delete(obj);	
	}
}
