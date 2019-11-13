package br.com.fatesg.fabrica.projetofabrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPrestador {        
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
    @Column(name="descricao",length=200)
    private String descricao;    
    private boolean desativado;
    
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public boolean isDesativado() {
		return desativado;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setDesativado(boolean desativado) {
		this.desativado = desativado;
	}      
}
