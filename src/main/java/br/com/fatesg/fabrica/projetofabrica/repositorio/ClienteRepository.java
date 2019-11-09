package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
  
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
       
      List<Cliente> findById(@Param("id") int id);
               
      Cliente findDescricaoById(@Param("id") Long id);
      
      List<Cliente> findByIdOrderByNome(@Param("id") String nome);
  
}