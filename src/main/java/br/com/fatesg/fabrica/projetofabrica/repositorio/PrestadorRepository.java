package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Prestador;
  
@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
       
	Prestador findById(@Param("id") long id);
               
    Prestador findDescricaoById(@Param("id") Long id);
      
    List<Prestador> findByIdOrderByNome(@Param("id") String nome);

	Prestador findByCpfCnpj(String cpfCnpj);
}