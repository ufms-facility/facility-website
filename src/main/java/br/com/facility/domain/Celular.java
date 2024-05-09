package br.com.facility.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Celular implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String celularDesc;
	
	@ManyToOne
	@JoinColumn(name = "id_peptideo", nullable = false, updatable = true)
	private Peptideo peptideo;
	
	public Celular() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCelularDesc() {
		return celularDesc;
	}

	public void setCelularDesc(String celularDesc) {
		this.celularDesc = celularDesc;
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