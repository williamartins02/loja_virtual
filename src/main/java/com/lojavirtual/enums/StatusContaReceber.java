package com.lojavirtual.enums;

public enum StatusContaReceber {
	
	COBRANCA("Cobrança"), 
	VENCIDA ("Vencida"),
	ABERTA  ("Aberta"),
	QUITADA ("Quitada");
	
	
	private String descricao;
	
	private StatusContaReceber(String descricao) {
		
	
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusContaReceber toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		for(StatusContaReceber t: StatusContaReceber.values()) {
			if(descricao.equals(t.getDescricao())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}


}


