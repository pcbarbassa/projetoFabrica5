package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.repositorio.Cliente;
import br.com.fatesg.fabrica.projetofabrica.repositorio.ClienteRepository;

@Service
public class ClienteNeg {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	public List<Cliente> findById(int id){
    	return clienteRepository.findById(id);
    }
    
    public Cliente findDescricaoById(Long id) {
    	return clienteRepository.getOne(id);
    }
    
    public List<Cliente> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<Cliente> findAll() {
    	return clienteRepository.findAll();
    }

	public Cliente save(Cliente newCliente) {
		clienteRepository.save(newCliente);
		return newCliente;
	}
		
	public void deleteById(long id) {
		clienteRepository.deleteById(id);
	
	}
}
