package br.com.jg.loucademia.interfaces.acesso.web;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.jg.loucademia.domain.acesso.Acesso;

@Named
@RequestScoped
public class ControleAcessoBean implements Serializable{

	private String matricula;
	private Integer rg;
	
	private Acesso acesso = new Acesso();
	
	public String registrarAcesso() {
		String mensagem = " ";
		return mensagem;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	public Acesso getAcesso() {
		return acesso;
	}		
}
