package com.mgasistemas.model;

public enum TipoEmpresa {
	MEI("Microempreendedor Idividual"),
	EIRELI("Empresa Individual de Resposabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String descricao;
	
	TipoEmpresa(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
