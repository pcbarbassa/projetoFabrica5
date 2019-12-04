package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
public class Prestador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;     
	
	@Getter @Setter @NotNull 
	private String nome;	
	
	@Getter @Setter @Column(nullable=false, length=16, unique=true)  
	private String cpfCnpj;
	
	@Getter @Setter @Email @Column(nullable=false, length=100, unique = true)
    private String email;
	
	@Getter @Setter @NotNull @JsonFormat(pattern="yyyy-MM-dd")	  
	private Date dtNascimento;
	
	@Getter @Setter @NotNull  
	private String identidade;
	
	@Getter @Setter @OneToOne @Cascade(CascadeType.ALL)
	private Endereco endereco;
	
	@Getter @Setter @OneToOne
	private Banco banco;
	
	@Getter @Setter  
	private String agencia;
	
	@Getter @Setter @NotNull 
	private String conta;
	
	@Getter @Setter
	private String telefone;
	
	@Getter @Setter @OneToOne  
	private TipoPrestador tipoPrestador;
	
	@Getter @Setter
	private String senha;
	
	@Getter @Column(insertable=false, updatable=false)
	@org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.INSERT)
	private Date dtCadastro;
	    
}
