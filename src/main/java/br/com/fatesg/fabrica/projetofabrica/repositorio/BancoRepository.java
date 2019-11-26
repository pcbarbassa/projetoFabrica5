package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Banco;
  
@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
       
	Banco findById(@Param("id") int id);
	
	Banco findBancoById(@Param("id") int id);
	
	Banco findByNome(String descricao);
      
    List<Banco> findByIdOrderByNome(@Param("id") String nome);
  
}