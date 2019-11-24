package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	
	@Getter @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer cod;     
    
	@NotNull 
	private String banco;

}
