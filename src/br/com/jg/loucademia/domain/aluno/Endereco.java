package br.com.jg.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco implements Serializable{

	public Endereco() {
		estado = new Estado();
	}
	
	private static final long serialVersionUID = -3888650364591054376L;

	@Column(name = "RUA", nullable = false, length = 128)
	private String rua;
	
	@Column(name = "NUMERO", nullable = true, length = 6)
	private Integer numero;
	
	@Column(name = "COMPLEMENTO", nullable = true, length = 32)
	private String complemento;
	
	@Column(name = "CIDADE", nullable = false, length = 64)
	private String cidade;

	@Column(name = "CEP", nullable = false, length = 8)
	private Integer cep;
	
	@ManyToOne
	@JoinColumn(name = "ESTADO_ID", nullable = false)
	private Estado estado;

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}

	
}
