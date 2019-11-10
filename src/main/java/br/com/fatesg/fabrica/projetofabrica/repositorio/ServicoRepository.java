package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Servico;
  
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
       
      List<Servico> findById(@Param("id") int id);
               
      Servico findDescricaoById(@Param("id") Long id);
      
      List<Servico> findByIdOrderByDescricao(@Param("id") String descricao);
  
}