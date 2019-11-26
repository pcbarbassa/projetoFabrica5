package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.Banco;
import br.com.fatesg.fabrica.projetofabrica.repositorio.BancoRepository;

@Service
public class BancoNeg {
	
	@Autowired
	public BancoRepository repository;
	
	public Banco findById(Integer id){
    	return repository.findById(id);
    }
    
    public Banco findByIdOrderByNome(Long id) {
    	return repository.getOne(id);
    }
    
    public Banco findByNome(String nome) {
    	return repository.findByNome(nome);
    }   
    
    public List<Banco> findAll() {
    	return repository.findAll();
    }   

	public Banco save(Banco obj) {
		repository.save(obj);
		return obj;
	}
}
