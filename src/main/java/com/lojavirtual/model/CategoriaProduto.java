package com.lojavirtual.model;

import java.io.Serializable;

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
@Table(name = "categoria_produto")
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)
public class CategoriaProduto implements Serializable {
        private static final long serialVersionUID = 1L;
        
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
        private Long id;
        
        @Column(name = "nome_descricao", nullable = false)
        private String  nomeDesc;
        
        @JsonIgnore
    	@ManyToOne(targetEntity = Pessoa.class)//Muitos endereço  para uma pessoa, para class Pessoa.
    	@JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id__fk"))
    	private Pessoa empresa;
    	
        
}
