package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
  
@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
       
      List<Solicitacao> findById(@Param("id") int id);
            
      Solicitacao findDescricaoById(@Param("id") Long id);
      
      List<Solicitacao> findByIdOrderByDescricao(@Param("id") String descricao);
  
}