package com.lojavirtual.enums;

public enum StatusContaPagar {
	
	COBRANCA ("Cobrança"), 
	VENCIDA  ("Vencida"),
	ABERTA   ("Aberta"),
	QUITADA  ("Quitada"),
	NEGOCIADA("Negociado");
	
	
	private String descricao;
	
	private StatusContaPagar( String descricao) {
		
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusContaPagar toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		for(StatusContaPagar t: StatusContaPagar.values()) {
			if(descricao.equals(t.getDescricao())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}


}


