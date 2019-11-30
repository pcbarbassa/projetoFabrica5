package br.com.fatesg.fabrica.projetofabrica.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatesg.fabrica.projetofabrica.Cliente;
  
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
       
      Cliente findById(@Param("id") int id);
               
      Cliente findClienteById(@Param("id") Long id);
      
      String findNomeById(@Param("id") Long id);
      
      Cliente findByCpfCnpj(String cpfCnpj);
      
      List<Cliente> findByIdOrderByNome(@Param("id") String nome);
      
      Cliente findByEmail(String email);
  
}