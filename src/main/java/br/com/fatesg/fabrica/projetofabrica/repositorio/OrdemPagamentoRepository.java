package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.OrdemPagamento;
  
@Repository
public interface OrdemPagamentoRepository extends JpaRepository<OrdemPagamento, Long> {
       
	OrdemPagamento findById(@Param("id") int id);
               
	OrdemPagamento findDescricaoById(@Param("id") Long id);
      
    List<OrdemPagamento> findByIdOrderByData(@Param("id") Date data);
  
}