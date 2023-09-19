package com.lojavirtual.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//Class abstract que extend PessoaFisica/PessoaJuridica

@Getter @Setter  @EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)
public abstract class Pessoa implements Serializable {
	
        private static final long serialVersionUID = 1L;
        
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
        protected Long id;
        
        @Column(nullable = false)
        protected String nome;
        
        @Column(nullable = false)
        protected String email;
        
        @Column(nullable = false)
        protected String telefone;
        
        @JsonIgnore
        //orphanRemoval -> remover os enderecço em cascata quando a pessoa assoaciada for deletada.
        @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    	private List<Endereco> enderecos = new ArrayList<Endereco>();
            
        
}