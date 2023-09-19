package com.lojavirtual.enums;



public enum TipoEndereco {
	
	COBRANCA ("Cobrança"), ENTREGA ("Entrega");
	
	
	//private Integer codigo;
	private String descricao;
	
	private TipoEndereco(String descricao) {
		
		//this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//public Integer getCodigo() {
		//return codigo;
	//}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoEndereco toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		for(TipoEndereco t: TipoEndereco.values()) {
			if(descricao.equals(t.getDescricao())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Endreço invalido");
	}


}
