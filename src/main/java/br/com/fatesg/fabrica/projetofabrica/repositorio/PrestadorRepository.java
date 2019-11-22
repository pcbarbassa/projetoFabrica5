package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Prestador;
  
@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
       
	Prestador findById(@Param("id") long id);
               
    Prestador findDescricaoById(@Param("id") Long id);
      
    List<Prestador> findByIdOrderByNome(@Param("id") String nome);

	//Prestador findByDescricao(String descricao);
}