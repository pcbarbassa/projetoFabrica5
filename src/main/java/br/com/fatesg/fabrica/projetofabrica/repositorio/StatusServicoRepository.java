package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.StatusServico;
import br.com.fatesg.fabrica.projetofabrica.StatusSolicitacao;
  
@Repository
public interface StatusServicoRepository extends JpaRepository<StatusServico, Long> {
       
	StatusServico findById(@Param("id") long id);
               
	StatusServico findDescricaoById(@Param("id") Long id);
      
    List<StatusServico> findByIdOrderByDescricao(@Param("id") String descricao);
  
}