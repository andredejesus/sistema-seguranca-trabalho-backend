package br.com.saec.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
public class Colaborador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(length = 100, nullable = false)
	@NotEmpty
	private String nome;
	
	@Column(nullable = false)
	private LocalDate data_nascimento;
	
	@Column
	private String rg;
	
	
	//@CPF
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "id_dados_empresa", unique = true, nullable = false)
	private DadosEmpresa dadosEmpresa;
	
	
	/* Gets e Sets */

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public DadosEmpresa getDadosEmpresa() {
		return dadosEmpresa;
	}

	public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", rg=" + rg
				+ ", cpf=" + cpf + ", dadosEmpresa=" + dadosEmpresa + "]";
	}
	
	

}
