package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Solicitacao;
  
@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
       
      Solicitacao findById(@Param("id") int id);
            
      Solicitacao findDescricaoById(@Param("id") Long id);
      
      List<Solicitacao> findByIdOrderByDescricao(@Param("id") String descricao);
      
      List<Solicitacao> findByCliente_Id(@Param("id") long id);
  
}