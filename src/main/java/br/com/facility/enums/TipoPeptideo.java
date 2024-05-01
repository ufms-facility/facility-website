package br.com.facility.enums;

public enum TipoPeptideo {
	SINTETIZADO("Sintetizado"),NATURAL("Natural");
	
	private String descricao;
	
	TipoPeptideo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}