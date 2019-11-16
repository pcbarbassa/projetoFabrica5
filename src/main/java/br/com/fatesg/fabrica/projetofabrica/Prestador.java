package br.com.fatesg.fabrica.projetofabrica;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
public class Prestador {  
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Setter private int id;     
	@NotNull @Getter @Setter private String nome;
	@NotNull @Getter @Setter private String cpf_cnpj;
	@NotNull @Getter @Setter private String email;
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull @Getter @Setter private Date dt_nascimento;
	@NotNull @Getter @Setter private String identidade;
	@NotNull @Getter @Setter private String endereco;
	@NotNull @Getter @Setter private String cod_banco;
	@NotNull @Getter @Setter private String agencia;
	@NotNull @Getter @Setter private String conta;
	@OneToOne
	@Getter @Setter private TipoPrestador tipoPrestador; 
	    
}
