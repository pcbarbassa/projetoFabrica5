package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Id
	private Integer id;     
    
	@Getter @OrderBy 
	private String nome;

}
