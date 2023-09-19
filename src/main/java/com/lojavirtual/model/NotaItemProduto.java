package com.lojavirtual.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@Entity
@Table(name = "nota_item_produto")
@SequenceGenerator(name = "seq_nota_item_produto", sequenceName = "seq_nota_item_produto", allocationSize = 1, initialValue = 1)
public class NotaItemProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_item_produto")
	private Long id;
	
	@Column(nullable = false)
	private Double quantidade;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "nota_fiscal_produto_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_produto_fk"))
	private NotaFiscalCompra notaFiscalCompra;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(
			value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
	private Produto produto;
	

}
