package br.com.facility.dto;

import br.com.facility.domain.Celular;
import br.com.facility.domain.Peptideo;

public class CelularDTO {
	private Long id;
	private String celularDesc;
	private Peptideo peptideo;

	public CelularDTO(Celular celular) {
		this.id = celular.getId();
		this.celularDesc = celular.getCelularDesc();
		this.peptideo = celular.getPeptideo();
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

	public String getCelularDesc() {
		return celularDesc;
	}

	public void setCelularDesc(String celularDesc) {
		this.celularDesc = celularDesc;
	}
	

}
