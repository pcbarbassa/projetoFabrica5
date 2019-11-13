package br.com.fatesg.fabrica.projetofabrica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
public class Cliente {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Getter private int id;     
    @NotNull @Getter @Setter private String nome;
    @NotNull @Getter @Setter private String cpf_cnpj;
    @NotNull @Getter @Setter @Email private String email;
    @NotNull @Getter @Setter private Date dt_nascimento;
    @Getter @Setter private String identidade;
    @Getter @Setter private String endereco;      
}
