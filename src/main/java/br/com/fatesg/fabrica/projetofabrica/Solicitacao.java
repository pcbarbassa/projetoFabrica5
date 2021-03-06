package br.com.fatesg.fabrica.projetofabrica;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonFormat;

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
      private Integer id;
       
      @Getter @Setter
      private Float valor;
      
      @Getter @Setter @JsonFormat(pattern="yyyy-MM-dd")
      private Date data;
      
      @Getter @Setter @OneToOne @OrderBy
      private StatusSolicitacao statusSolicitacao;
      
      @Getter @Setter
      private String descricao;
      
      @Getter @Setter @OneToOne
      private Cliente cliente;
      
      @Getter @Setter @OneToOne
      private TipoPrestador tipoPrestador;
}
