package br.com.fatesg.fabrica.projetofabrica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
public class OrdemPagamento {        
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Getter private long id;
    @Getter @Setter private Date data;
    @Getter @Setter private Float valor;
    @OneToOne
    @Getter @Setter private Solicitacao solicitacao;
    
}
