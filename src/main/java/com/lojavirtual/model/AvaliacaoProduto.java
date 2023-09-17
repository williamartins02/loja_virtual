package com.lojavirtual.model;

import java.io.Serializable;

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
@Table(name = "avalicao_produto")
@SequenceGenerator(name = "seq_avalicao_produto", sequenceName = "seq_avalicao_produto", allocationSize = 1, initialValue = 1)
public class AvaliacaoProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avalicao_produto")
       private Long id;
	   private String descricao;
	   private Integer nota;
	   
	   
		@JsonIgnore
		@ManyToOne(targetEntity = Pessoa.class)
		@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(
				    value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
		private Pessoa pessoa;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(
				    value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
		private Produto produto;
	   
	
	

}