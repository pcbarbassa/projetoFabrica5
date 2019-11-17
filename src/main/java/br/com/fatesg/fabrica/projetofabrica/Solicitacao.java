package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;      
          
      @Getter @Id @GeneratedValue(strategy=GenerationType.AUTO) 
      private Long id;
       
      @Getter @Setter
      private double valorTotal;
      
      @Getter @Setter
      private int numeroProdutos;
      
      @Getter @Setter
      private String descricao;
      
      @Getter @Setter @OneToOne 
      private OrdemServico ordemServico;
      
      @Getter @Setter @OneToOne
      private Cliente cliente;
}
