package br.com.sast.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Treinamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private String nm_treinamento;
	private LocalDate data_treinamento;
	private Integer dias_vencimento;
	private LocalDate data_vencimento;
	
	@ManyToOne
	@JoinColumn(name = "id_colaborador", referencedColumnName = "id")
	private Colaborador colaborador;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNm_treinamento() {
		return nm_treinamento;
	}

	public void setNm_treinamento(String nm_treinamento) {
		this.nm_treinamento = nm_treinamento;
	}

	public LocalDate getData_treinamento() {
		return data_treinamento;
	}

	public void setData_treinamento(LocalDate data_treinamento) {
		this.data_treinamento = data_treinamento;
	}

	public Integer getDias_vencimento() {
		return dias_vencimento;
	}

	public void setDias_vencimento(Integer dias_vencimento) {
		this.dias_vencimento = dias_vencimento;
	}

	public LocalDate getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(LocalDate data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	

	public Treinamento() {
		super();
	}

	public Treinamento(String nm_treinamento, LocalDate data_treinamento, Integer dias_vencimento,
			LocalDate data_vencimento, Colaborador colaborador) {
		super();
		this.nm_treinamento = nm_treinamento;
		this.data_treinamento = data_treinamento;
		this.dias_vencimento = dias_vencimento;
		this.data_vencimento = data_vencimento;
		this.colaborador = colaborador;
	}

	@Override
	public String toString() {
		return "Treinamento [id=" + id + ", nm_treinamento=" + nm_treinamento + ", data_treinamento=" + data_treinamento
				+ ", dias_vencimento=" + dias_vencimento + ", data_vencimento=" + data_vencimento + ", colaborador="
				+ colaborador + "]";
	}
	
	
	
}
