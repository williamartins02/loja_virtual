package com.lojavirtual.enums;

public enum StatusContaReceber {
	
	OBRANCA (0,"Cobrança"), 
	VENCIDA (1,"Vencida"),
	ABERTA  (2,"Aberta"),
	QUITADA (3, "Quitada");
	
	private Integer codigo;
	private String descricao;
	
	private StatusContaReceber(Integer codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusContaReceber toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(StatusContaReceber t: StatusContaReceber.values()) {
			if(cod.equals(t.getCodigo())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}


}


