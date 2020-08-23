package br.com.sast.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity
public class Aso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(nullable = false)
	@NotEmpty
	private String colaborador;
	
	@Column(nullable = false)
	@NotEmpty
	private String tipo_aso;
	
	@Column(nullable = false)
	@NotEmpty
	private String data_emissao;
	
	@Column(nullable = false)
	private Integer dias_vencimento;
	
	@Column(nullable = false)
	@NotEmpty
	private String data_vencimento;
	
	//@OneToMany(mappedBy = "aso", fetch = FetchType.LAZY)
	//private List<Exames> exames = new ArrayList<>();
	
	
	// Gets e Sets

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getTipo_aso() {
		return tipo_aso;
	}

	public void setTipo_aso(String tipo_aso) {
		this.tipo_aso = tipo_aso;
	}

	public String getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(String data_emissao) {
		this.data_emissao = data_emissao;
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

	//public List<Exames> getExames() {
		//return exames;
	//}

	//public void setExames(List<Exames> exames) {
		//this.exames = exames;
	//}
	
	
	
	

}
