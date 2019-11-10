package br.com.fatesg.fabrica.projetofabrica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {
  
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)    
      private Long id;
       
      private double valorTotal;
      private int numeroServicos;
      private String descricao;
      
      public Servico(String descricao, double valorTotal)
      {
    	  this.valorTotal = valorTotal;
    	  this.setDescricao(descricao);
      }       
  
      public Servico() {}
           
      
      public Long getId() {
            return id;
      }
  
      public void setId(Long id) {
            this.id = id;
      }
  
      public double getValorTotal() {
            return valorTotal;
      }
  
      public void setValorTotal(double valorTotal) {
            this.valorTotal = valorTotal;
      }
  
      public int getNumeroServicos() {
            return numeroServicos;
      }
  
      public void setNumeroServicos(int numeroServicos) {
            this.numeroServicos = numeroServicos;
      }

		public String getDescricao() {
			return descricao;
		}
	
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	       
}
