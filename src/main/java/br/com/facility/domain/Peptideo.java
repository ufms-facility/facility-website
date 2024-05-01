package br.com.facility.domain;

import org.springframework.data.annotation.Id;

import br.com.facility.enums.TipoPeptideo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Peptideo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String peptideo;
	private Integer quantAas;
	private TipoPeptideo tipoPeptideo;
	private String sequencia;
	private String estruturaTridimensional;
	private Double massaMolecular;
	private Double impediEsterico;
	private Double hidrofobocidade;
	private Double pontoIsoeletrico;
	private Double hidropatia;
	private Double anfipaticidade;
	private Double hidrofilicidade;
	private Integer cargaLiquiTotal;
	private Double indiceBoman;
	private String descricao;
	
	public Peptideo() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeptideo() {
		return peptideo;
	}

	public void setPeptideo(String peptideo) {
		this.peptideo = peptideo;
	}

	public Integer getQuantAas() {
		return quantAas;
	}

	public void setQuantAas(Integer quantAas) {
		this.quantAas = quantAas;
	}

	public TipoPeptideo getTipoPeptideo() {
		return tipoPeptideo;
	}

	public void setTipoPeptideo(TipoPeptideo tipoPeptideo) {
		this.tipoPeptideo = tipoPeptideo;
	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	public String getEstruturaTridimensional() {
		return estruturaTridimensional;
	}

	public void setEstruturaTridimensional(String estruturaTridimensional) {
		this.estruturaTridimensional = estruturaTridimensional;
	}

	public Double getMassaMolecular() {
		return massaMolecular;
	}

	public void setMassaMolecular(Double massaMolecular) {
		this.massaMolecular = massaMolecular;
	}

	public Double getImpediEsterico() {
		return impediEsterico;
	}

	public void setImpediEsterico(Double impediEsterico) {
		this.impediEsterico = impediEsterico;
	}

	public Double getHidrofobocidade() {
		return hidrofobocidade;
	}

	public void setHidrofobocidade(Double hidrofobocidade) {
		this.hidrofobocidade = hidrofobocidade;
	}

	public Double getPontoIsoeletrico() {
		return pontoIsoeletrico;
	}

	public void setPontoIsoeletrico(Double pontoIsoeletrico) {
		this.pontoIsoeletrico = pontoIsoeletrico;
	}

	public Double getHidropatia() {
		return hidropatia;
	}

	public void setHidropatia(Double hidropatia) {
		this.hidropatia = hidropatia;
	}

	public Double getAnfipaticidade() {
		return anfipaticidade;
	}

	public void setAnfipaticidade(Double anfipaticidade) {
		this.anfipaticidade = anfipaticidade;
	}

	public Double getHidrofilicidade() {
		return hidrofilicidade;
	}

	public void setHidrofilicidade(Double hidrofilicidade) {
		this.hidrofilicidade = hidrofilicidade;
	}

	public Integer getCargaLiquiTotal() {
		return cargaLiquiTotal;
	}

	public void setCargaLiquiTotal(Integer cargaLiquiTotal) {
		this.cargaLiquiTotal = cargaLiquiTotal;
	}

	public Double getIndiceBoman() {
		return indiceBoman;
	}

	public void setIndiceBoman(Double indiceBoman) {
		this.indiceBoman = indiceBoman;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}