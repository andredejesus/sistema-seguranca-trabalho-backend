package br.com.sast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Exames {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(nullable = false)
	@NotEmpty
	private String exame;
	
	@Column(nullable = false)
	@NotEmpty
	private String data_exame;
	
	@Column(nullable = false)
	@NotEmpty
	private String data_vencimento;
	
	@Column(nullable = false)
	private Integer dias_vencimento;
	
	@Column(nullable = false)
	@NotEmpty
	private String status;
	
	private Short id_aso;
	
	
	// Gests e Sets

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getData_exame() {
		return data_exame;
	}

	public void setData_exame(String data_exame) {
		this.data_exame = data_exame;
	}

	public String getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getId_aso() {
		return id_aso;
	}

	public void setId_aso(Short id_aso) {
		this.id_aso = id_aso;
	}

	public Integer getDias_vencimento() {
		return dias_vencimento;
	}

	public void setDias_vencimento(Integer dias_vencimento) {
		this.dias_vencimento = dias_vencimento;
	}


}
