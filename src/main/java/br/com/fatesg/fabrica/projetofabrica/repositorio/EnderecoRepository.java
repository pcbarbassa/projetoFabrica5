package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Endereco;
  
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
       
	Endereco findById(@Param("id") int id);
               
	Endereco findDescricaoById(@Param("id") Long id);
      
    List<Endereco> findByIdOrderByCep(@Param("id") String Cep);
  
}