package com.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@Entity
@Table(name = "nota_fiscal_compra")
@SequenceGenerator(name = "seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
	private Long id;
	private String numeroNota;
	private String serieNota;
	private String descricaoObs;
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	private BigDecimal valorIcms;

	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Pessoa.class)//Muitos endereço  para uma pessoa, para class Pessoa.
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "conta_pagar_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
	private ContaPagar contaPagar;
	

}
