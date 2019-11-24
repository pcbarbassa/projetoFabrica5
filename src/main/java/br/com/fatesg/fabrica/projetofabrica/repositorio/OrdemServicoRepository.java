package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.OrdemServico;
  
@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
       
	OrdemServico findById(@Param("id") long id);
               
	OrdemServico findDescricaoById(@Param("id") Long id);
      
    List<OrdemServico> findByIdOrderByDescricao(@Param("id") String nome);
    
    List<OrdemServico> findByPrestador_Id(@Param("id") long id);
    
    List<OrdemServico> findBySolicitacao_Cliente_Id(@Param("id") long id);
  
}