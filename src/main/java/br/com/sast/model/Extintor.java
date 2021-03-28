package br.com.sast.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Extintor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(nullable = false)
	private String nuPatrimonio;
	
	@Column(nullable = true)
	private String lacre;
	
	@Column(nullable = true)
	private String nuInmetro;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private Integer ltKg;
	
	@Column(nullable = false)
	private String data_recarga;
	
	@Column(nullable = false)
	private Integer dias_vencimento;
	
	@Column(nullable = false)
	private String data_vencimento;
	
	@Column(nullable = false)
	private String localizacao;
	
	

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}
	
	

	public String getNuPatrimonio() {
		return nuPatrimonio;
	}

	public void setNuPatrimonio(String nuPatrimonio) {
		this.nuPatrimonio = nuPatrimonio;
	}

	public String getLacre() {
		return lacre;
	}

	public void setLacre(String lacre) {
		this.lacre = lacre;
	}

	public String getNuInmetro() {
		return nuInmetro;
	}

	public void setNuInmetro(String nuInmetro) {
		this.nuInmetro = nuInmetro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getLtKg() {
		return ltKg;
	}

	public void setLtKg(Integer ltKg) {
		this.ltKg = ltKg;
	}

	public String getData_recarga() {
		return data_recarga;
	}

	public void setData_recarga(String data_recarga) {
		this.data_recarga = data_recarga;
	}

	public Integer getDias_vencimento() {
		return dias_vencimento;
	}

	public void setDias_vencimento(Integer dias_vencimento) {
		this.dias_vencimento = dias_vencimento;
	}

	public String getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Extintor [id=" + id + ", lacre=" + lacre + ", nuInmetro=" + nuInmetro + ", tipo=" + tipo + ", ltKg="
				+ ltKg + ", data_recarga=" + data_recarga + ", dias_vencimento=" + dias_vencimento
				+ ", data_vencimento=" + data_vencimento + ", localizacao=" + localizacao + "]";
	}
	
	

}
