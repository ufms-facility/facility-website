package br.com.facility.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Microbiologia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String microbioDesc;
	
	@ManyToOne
	@JoinColumn(name = "id_peptideo", nullable = false, updatable = true)
	private Peptideo peptideo;

	public Microbiologia() {
		
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}