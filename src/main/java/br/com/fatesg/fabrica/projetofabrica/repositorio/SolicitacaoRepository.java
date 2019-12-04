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
      
      List<Solicitacao> findAllOrderByStatusSolicitacao_Id(@Param("id")  int id);
      
      List<Solicitacao> findByIdOrderByDescricao(@Param("id") String descricao);
      
      List<Solicitacao> findByCliente_Id(@Param("id") int id);
      
      List<Solicitacao> findByTipoPrestador_Id(@Param("id") int id);
      
      List<Solicitacao> findByStatusSolicitacao_Id(@Param("id") int id);
      
      List<Solicitacao> findByTipoPrestador_IdAndStatusSolicitacao_Id(@Param("tipoPrestadorId") Integer tipoPrestadorId, 
    		  @Param("statusSolicitacaoId") Integer statusSolicitacaoId);
      
      List<Solicitacao> findByStatusSolicitacao_IdAndTipoPrestador_Id(@Param("tipoPrestadorId") Integer tipoPrestadorId, 
    		  @Param("statusSolicitacaoId") Integer statusSolicitacaoId);
}