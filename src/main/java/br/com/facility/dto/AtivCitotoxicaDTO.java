package br.com.facility.dto;

import br.com.facility.domain.AtivCitotoxica;
import br.com.facility.domain.Peptideo;

public class AtivCitotoxicaDTO {
	private Long id;
	private String ativCitotoxicDesc;
	private Peptideo peptideo;

	public AtivCitotoxicaDTO(AtivCitotoxica ativCitotoxica) {
		this.id = ativCitotoxica.getId();
		this.ativCitotoxicDesc = ativCitotoxica.getAtivCitotoxicDesc();
		this.peptideo = ativCitotoxica.getPeptideo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Peptideo getPeptideo() {
		return peptideo;
	}

	public void setPeptideo(Peptideo peptideo) {
		this.peptideo = peptideo;
	}

	public String getAtivCitotoxicDesc() {
		return ativCitotoxicDesc;
	}

	public void setAtivCitotoxicDesc(String celularDesc) {
		this.ativCitotoxicDesc = celularDesc;
	}
	

}
