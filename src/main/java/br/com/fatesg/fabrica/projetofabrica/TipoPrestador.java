package br.com.fatesg.fabrica.projetofabrica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
public class TipoPrestador {        
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Getter private long id;
    @Getter @Setter private String descricao;
    @Getter @Setter private boolean desativado;      
}
