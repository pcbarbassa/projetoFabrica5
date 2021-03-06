package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.StatusSolicitacao;
  
@Repository
public interface StatusSolicitacaoRepository extends JpaRepository<StatusSolicitacao, Long> {
       
	StatusSolicitacao findById(@Param("id") int id);
               
	StatusSolicitacao findDescricaoById(@Param("id") Long id);
      
    List<StatusSolicitacao> findByIdOrderByDescricao(@Param("id") String descricao);
  
}