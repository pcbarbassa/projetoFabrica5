package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Id	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@Getter @Setter @Column(nullable=false, length=100, unique = true) 
	private String login;
	
	@Getter @Setter 
	private String senha;
	
    @Getter @Setter 
    private boolean ativo;
    
    @Getter @Setter 
    private boolean ehAdmin;
    
    
}
