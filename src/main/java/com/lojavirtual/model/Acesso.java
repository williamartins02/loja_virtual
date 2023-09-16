package com.lojavirtual.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import org.springframework.security.core.GrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @EqualsAndHashCode
@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
//Class de autorização do spring security
public class Acesso implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
	private Long id;
	@Column(nullable = false)//Anotacao para dizer que descricao precisa ser obrigatorio
	private String descricao; 

	@Override
	public String getAuthority() {
		return this.descricao;
	}
}
