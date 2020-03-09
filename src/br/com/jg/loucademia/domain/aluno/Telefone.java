package br.com.jg.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone implements Serializable{
	
	public Telefone() {
		
	}
	
	private static final long serialVersionUID = 8531927021125948349L;

	@Column(name = "DDD_CELULAR", nullable = false, length = 2)
	private Integer dddCelular;
	
	@Column(name = "NUMERO_CELULAR", nullable = false, length = 9)
	private Integer numeroCelular;
	
	@Column(name = "DDD_FIXO", nullable = true, length = 2)
	private Integer dddFixo;
	
	@Column(name = "NUMERO_FIXO", nullable = true, length = 9)
	private Integer numeroFixo;
	
	public Integer getDddCelular() {
		return dddCelular;
	}
	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}
	public Integer getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public Integer getDddFixo() {
		return dddFixo;
	}
	public void setDddFixo(Integer dddFixo) {
		this.dddFixo = dddFixo;
	}
	public Integer getNumeroFixo() {
		return numeroFixo;
	}
	public void setNumeroFixo(Integer numeroFixo) {
		this.numeroFixo = numeroFixo;
	}
	
	
}
