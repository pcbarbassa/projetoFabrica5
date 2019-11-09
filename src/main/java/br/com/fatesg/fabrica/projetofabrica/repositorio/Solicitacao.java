package br.com.fatesg.fabrica.projetofabrica.repositorio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitacao {
  
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)    
      private Long id;
       
      private double valorTotal;
      private int numeroProdutos;
      private String descricao;
      public Solicitacao() {}
      
      public Solicitacao(double valorTotal, String descricao) {
    	  this.valorTotal = valorTotal;
    	  this.setDescricao(descricao);
      }
      
      public Long getId() {
            return id;
      }
  
      public void setId(Long id) {
            this.id = id;
      }
  
      public double getValorTotal() {
            return valorTotal;
      }
  
      public void setValorTotal(float valorTotal) {
            this.valorTotal = valorTotal;
      }
  
      public int getNumeroProdutos() {
            return numeroProdutos;
      }
  
	  public void setNumeroProdutos(int numeroProdutos) {
	        this.numeroProdutos = numeroProdutos;
	  }

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
       
}
