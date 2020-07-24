package br.com.sast.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class DadosEmpresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id; 
	
	@Column(length = 50, nullable = false)
	@NotEmpty
	private String funcao;
	
	@Column(length = 50, nullable = false)
	@NotEmpty
	private String lotacao;
	
	@Column(length = 50, nullable = false)
	@NotEmpty
	private String departamento;
	
	@Column
	@NotNull
	private LocalDate data_admissao;
	
	@Column(length = 50, nullable = false)
	@NotEmpty
	private String situacao;
	
	//@OneToOne
	//@JoinColumn(name = "id_colaborador",  unique = true, nullable = false)
	//private Colaborador colaborador;
	
	
	/* Gets e Sets */

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public LocalDate getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(LocalDate data_admissao) {
		this.data_admissao = data_admissao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "DadosEmpresa [id=" + id + ", funcao=" + funcao + ", lotacao=" + lotacao + ", departamento="
				+ departamento + ", data_admissao=" + data_admissao + ", situacao=" + situacao + "]";
	}

	//public Colaborador getColaborador() {
		//return colaborador;
	//}

	//public void setColaborador(Colaborador colaborador) {
		//this.colaborador = colaborador;
	//}
	
	
	
	
	
}
