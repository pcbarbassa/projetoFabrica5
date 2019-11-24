package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;	
	 
	@Getter @Id @GeneratedValue(strategy=GenerationType.AUTO)  
	private Integer id;
    
	@Getter @Setter @NotNull @JsonFormat(pattern="yyyy-MM-dd")	
	private Date data;
    
	@Getter @Setter 
	private String descricao;
    
	@Getter @Setter 
	private Float valor;
    
	@Getter @Setter @OneToOne
	private StatusServico statusServico;
	
	@Getter @Setter @OneToOne 
	private Prestador prestador;
	    
	@Getter @Setter @OneToOne 
	private Solicitacao solicitacao;
}


