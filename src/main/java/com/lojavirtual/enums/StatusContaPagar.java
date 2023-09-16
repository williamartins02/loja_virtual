package com.lojavirtual.enums;

public enum StatusContaPagar {
	
	OBRANCA  (0,"Cobrança"), 
	VENCIDA  (1,"Vencida"),
	ABERTA   (2,"Aberta"),
	QUITADA  (3, "Quitada"),
	NEGOCIADA(4, "Negociado");
	
	private Integer codigo;
	private String descricao;
	
	private StatusContaPagar(Integer codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusContaPagar toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(StatusContaPagar t: StatusContaPagar.values()) {
			if(cod.equals(t.getCodigo())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}


}


