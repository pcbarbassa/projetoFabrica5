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
public class StatusServico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Id	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@Getter @Setter @Column(nullable=false, length=512, unique = true) 
	private String descricao;
	
    @Getter @Setter 
    private boolean ativo;     
    
}
