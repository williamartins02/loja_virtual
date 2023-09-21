package com.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;
	
	@Column(nullable = false)
	private String tipoUnidade;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Boolean ativo = Boolean.TRUE;
	
	@Column(columnDefinition = "text", length = 2000, nullable = false)
	private String descricao;
	
      /*Nota item nota produto - ASSOCCIAR*/
	@Column(nullable = false)
	private Double peso;
	
	@Column(nullable = false)
	private Double largura;
	
	@Column(nullable = false)
	private Double altura;
	
	@Column(nullable = false)
	private Double profundidade;
	
	@Column(nullable = false)
	private BigDecimal valorVenda = BigDecimal.ZERO;
	
	@Column(nullable = false)
	private Integer qtdEstoque = 0;
	
	private Integer qtdAlertaEstoque = 0;
	
	private String linkYoutube;
	
	private Boolean alertaQtdEstoque = Boolean.FALSE ;
	
	private Integer qtdClique = 0;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Pessoa.class)//Muitos endereço  para uma pessoa, para class Pessoa.
	@JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id__fk"))
	private Pessoa empresa;
	
}
