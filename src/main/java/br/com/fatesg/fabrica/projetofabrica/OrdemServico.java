package br.com.fatesg.fabrica.projetofabrica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
public class OrdemServico {        
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Getter private long id;
    @Getter @Setter private Date data;
    @Getter @Setter private String descricao;
    @Getter @Setter private Float valor;
    @Getter @Setter private int status_servico;
    @ManyToOne
    @Getter @Setter private Servico servico;
    
}
