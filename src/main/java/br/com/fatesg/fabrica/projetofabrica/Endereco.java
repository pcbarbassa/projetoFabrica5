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
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;	
	 
	@Getter @Id @GeneratedValue(strategy=GenerationType.AUTO)  
	private Integer id;     
    
	@Getter @Setter @NotNull
	private String logradouro;
    
	@Getter @Setter 
	private String cep;	
	
	@Getter @Setter 
	private String lat;	
	
	@Getter @Setter 
	private String lon;	
    
	@Getter @Setter @NotNull
	private String cidade;
    
	@Getter @Setter @NotNull
	private String estado;	 
    
	@Getter @Setter
	private String pais;
	
}

