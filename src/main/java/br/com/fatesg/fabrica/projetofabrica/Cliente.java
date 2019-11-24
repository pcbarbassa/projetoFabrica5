package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;	
	 
	@Getter @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;     
    
	@Getter @Setter @NotNull
	private String nome;
    	    
	@Getter @Setter @NotNull @Column(nullable=false, length=16, unique = true)
	private String cpfCnpj;    	
    
    @Getter @Setter @NotNull @Email @Column(nullable=false, length=100, unique = true)
    private String email;
	    	
    @NotNull @Getter @Setter @JsonFormat(pattern="yyyy-MM-dd")
    private Date dtNascimento;	
    	
	@Getter @Setter 
	private String identidade;
    
	@Getter @Setter @ManyToOne
	private Endereco endereco;
	
	@Getter @Column(insertable=false, updatable=false)
	@org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.INSERT)
	private Date dtCadastro;
	    
}
