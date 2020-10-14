package br.com.sast.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class DadosEmpresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id; 
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "{campo.funcao.obrigatorio}")
	private String funcao;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "{campo.lotacao.obrigatorio}")
	private String lotacao;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "{campo.departamento.obrigatorio}")
	private String departamento;
	
	@Column(nullable = false)
	@NotEmpty(message = "{campo.dataAdmissao.obrigatorio}")
	private String data_admissao;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "{campo.situacao.obrigatorio}")
	private String situacao;
	
	
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

	public String getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(String data_admissao) {
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

	//public ColaboradorQuery getColaborador() {
		//return colaborador;
	//}

	//public void setColaborador(ColaboradorQuery colaborador) {
		//this.colaborador = colaborador;
	//}
	
	
	
	
	
}
