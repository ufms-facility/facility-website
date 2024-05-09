package br.com.facility.dto;

import br.com.facility.domain.NomePopular;
import br.com.facility.domain.Organismo;

public class NomePopularDTO {
	private Long id;
	private String nome;
	private Organismo organismo;

	public NomePopularDTO(NomePopular nomePopular) {
		this.id = nomePopular.getId();
		this.nome = nomePopular.getNome();
		this.organismo = nomePopular.getOrganismo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

}
