package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.Administrador;
import br.com.fatesg.fabrica.projetofabrica.repositorio.AdministradorRepository;

@Service
public class AdministradorNeg {
	
	@Autowired
	public AdministradorRepository repository;
	
	public Administrador findById(Integer id){
    	return repository.findById(id);
    }
    
    public Administrador findByIdOrderByNome(Long id) {
    	return repository.getOne(id);
    }
    
    public List<Administrador> findAll() {
    	return repository.findAll();
    }   


	public Administrador save(Administrador obj) {
		repository.save(obj);
		return obj;
	}
		
	public void removerPorId(long id) {
		repository.deleteById(id);
	
	}
	
	public void remover(Administrador administrador) {
		repository.delete(administrador);
	
	}
}
