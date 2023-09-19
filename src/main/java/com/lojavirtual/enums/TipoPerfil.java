/*package com.lojavirtual.enums;

public enum TipoPerfil {
	
	JURIDICO,
	FISICO ;
	
	private String descricao;
	

	public String getDescricao() {
		return descricao;
	}
	
	//se o codigo digitado for igual a nulo, retorna nulo
	public static TipoPerfil toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		// laço para comparar o codigo digitado, se for o cod certo retorna o cod
		for(TipoPerfil p : TipoPerfil.values()) {
			if(descricao.equals(p.getDescricao())) {
				return p;  
				
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}
	

}*/
