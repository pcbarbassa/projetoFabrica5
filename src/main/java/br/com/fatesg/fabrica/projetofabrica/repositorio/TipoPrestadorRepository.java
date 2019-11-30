package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.TipoPrestador;
  
@Repository
public interface TipoPrestadorRepository extends JpaRepository<TipoPrestador, Long> {
       
	TipoPrestador findById(@Param("id") int id);
      
    List<TipoPrestador> findByIdOrderByDescricao(@Param("id") String descricao);

	TipoPrestador findByDescricao(String descricao);

	List<TipoPrestador> findByAtivoTrue();
  
}