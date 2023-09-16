package com.lojavirtual.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//Class Extend class Pessoa

@Getter @Setter @ToString 
@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String cnpj;
	
	private String inscEstadual;
	private String inscMunicipal;
	private String nomeFantasia;
	private String razaoSocial;
	private String categoria;
}
