package br.com.fatesg.fabrica.projetofabrica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
  
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)    
      private Long id;
     
      private String nome;
      private String documento;
      private String idade;
      private String rg;
      private String endereco;
      private String cidade;
      
      
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Cliente(String nome, String documento, String idade, String rg, String endereco, String cidade)
      {
		  this.nome = nome;
		  this.documento = documento;
		  this.idade = idade;
		  this.rg = rg;
		  this.endereco = endereco;
		  this.cidade = cidade;
      }       
  
      public Cliente() {}
           
      
      public Long getId() {
            return id;
      }
  
      public void setId(Long id) {
            this.id = id;
      }
  
      
}
