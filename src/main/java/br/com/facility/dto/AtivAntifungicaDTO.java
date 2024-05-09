package br.com.facility.dto;

import br.com.facility.domain.AtivAntifungica;
import br.com.facility.domain.Peptideo;

public class AtivAntifungicaDTO {
	private Long id;
	private String ativAntiFungDesc;
	private Peptideo peptideo;

	public AtivAntifungicaDTO(AtivAntifungica ativAntifung) {
		this.id = ativAntifung.getId();
		this.ativAntiFungDesc = ativAntifung.getAtivAntiFungDesc();
		this.peptideo = ativAntifung.getPeptideo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtivAntiFungDesc() {
		return ativAntiFungDesc;
	}

	public void setAtivAntiFungDesc(String ativAntiFungDesc) {
		this.ativAntiFungDesc = ativAntiFungDesc;
	}

	public Peptideo getPeptideo() {
		return peptideo;
	}

	public void setPeptideo(Peptideo peptideo) {
		this.peptideo = peptideo;
	}

}
