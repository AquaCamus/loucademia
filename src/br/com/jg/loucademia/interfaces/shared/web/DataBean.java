package br.com.jg.loucademia.interfaces.shared.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.jg.loucademia.application.service.DataService;
import br.com.jg.loucademia.domain.aluno.Aluno.Sexo;
import br.com.jg.loucademia.domain.aluno.Aluno.Situacao;
import br.com.jg.loucademia.domain.aluno.Estado;

@Named
@ApplicationScoped
public class DataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6134463053273394543L;
	@EJB
	private DataService dataService;
	
	public Sexo[] getSexos() {
		return dataService.getSexos();
	}
	
	public Situacao[] getSituacao() {
		return dataService.getSituacao();
	}
	
	public List<Estado> getEstados(){
		return dataService.listEstados();
	}
}
