package br.com.facility.dto;

import br.com.facility.domain.Microbiologia;
import br.com.facility.domain.Peptideo;

public class MicrobiologiaDTO {
	private Long id;
	private String microbioDesc;
	private Peptideo peptideo;

	public MicrobiologiaDTO(Microbiologia microbiologia) {
		this.id = microbiologia.getId();
		this.microbioDesc = microbiologia.getMicrobioDesc();
		this.peptideo = microbiologia.getPeptideo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMicrobioDesc() {
		return microbioDesc;
	}

	public void setMicrobioDesc(String microbioDesc) {
		this.microbioDesc = microbioDesc;
	}

	public Peptideo getPeptideo() {
		return peptideo;
	}

	public void setPeptideo(Peptideo peptideo) {
		this.peptideo = peptideo;
	}
	
	

}
