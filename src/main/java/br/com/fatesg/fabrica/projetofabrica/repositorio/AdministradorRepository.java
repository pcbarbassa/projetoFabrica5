package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Administrador;
  
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
       
	Administrador findById(@Param("id") int id);
	           
	Administrador findClienteById(@Param("id") Long id);
	      
	String findNomeById(@Param("id") Long id);
	  
	List<Administrador> findByIdOrderByNome(@Param("id") String nome);
  
}