package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;

import javax.persistence.Column;
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
public class TipoPrestador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY) @Getter private long id;
	@Getter @Setter @Column(name="descricao", nullable=false, length=512, unique = true) private String descricao;
    @Getter @Setter private boolean desativado;  
    
    public TipoPrestador() {
    	
    }
    
}
