package com.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@Entity
@Table(name = "vd_cp_loja_virt")
@SequenceGenerator(name = "seq_vd_cp_loja_virt", sequenceName = "seq_vd_cp_loja_virt", allocationSize = 1, initialValue = 1)
public class VendaCompraLojaVirt implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vd_cp_loja_virt")
	private Long id;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	@Column(nullable = false)
	private BigDecimal valorFrete;
	
	@Column(nullable = false)
	private Integer diasEntrega;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Pessoa.class)//usa o tasrget porque pessoal é uma class obstract
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "endereco_entrega_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "endereco_entrega_fk"))
	private Endereco enderecoEntrega;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "endereco_cobranca_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "endereco_cobranca_fk"))
	private Endereco enderecoCobranca;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "forma_pagamento_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "forma_pagamento_fk"))
	private FormaPagamento formaPagamento;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "nota_fical_venda_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "nota_fical_venda_fk"))
	private NotaFiscalVenda notaFiscalVenda;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cupom_desconto_id", foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "cupom_desconto_fk"))
	private CupDesc cupDesc;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Pessoa.class)//Muitos endereço  para uma pessoa, para class Pessoa.
	@JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id__fk"))
	private Pessoa empresa;

}

