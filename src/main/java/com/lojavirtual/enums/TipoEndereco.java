package com.lojavirtual.enums;



public enum TipoEndereco {
	
	COBRANCA (0,"Cobrança"), ENTREGA (1,"Entrega");
	
	
	private Integer codigo;
	private String descricao;
	
	private TipoEndereco(Integer codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoEndereco toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoEndereco t: TipoEndereco.values()) {
			if(cod.equals(t.getCodigo())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Endreço invalido");
	}


}
