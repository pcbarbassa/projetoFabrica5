package br.com.fatesg.fabrica.projetofabrica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatesg.fabrica.projetofabrica.repositorio.Servico;
import br.com.fatesg.fabrica.projetofabrica.repositorio.ServicoRepository;

@Service
public class ServicoNeg {
	
	@Autowired
	public ServicoRepository servicoRepository;
	
	public List<Servico> findById(int id){
    	return servicoRepository.findById(id);
    }
    
    public Servico findDescricaoById(Long id) {
    	return servicoRepository.getOne(id);
    }
    
    public List<Servico> findByIdOrderByDescricao(String descricao){
    	return null;
    }
    
    public List<Servico> findAll() {
    	return servicoRepository.findAll();
    }

}
