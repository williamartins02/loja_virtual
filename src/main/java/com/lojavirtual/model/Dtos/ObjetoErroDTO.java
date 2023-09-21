package com.lojavirtual.model.Dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString

public class ObjetoErroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String error;
	private String code;

}
