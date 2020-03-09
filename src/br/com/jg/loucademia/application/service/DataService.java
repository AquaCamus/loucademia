package br.com.jg.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.jg.loucademia.domain.aluno.Estado;
import br.com.jg.loucademia.domain.aluno.EstadoRepository;
import br.com.jg.loucademia.domain.aluno.Aluno.Sexo;
import br.com.jg.loucademia.domain.aluno.Aluno.Situacao;

@Stateless
public class DataService {

	@EJB
	private EstadoRepository er;
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacao() {
		return Situacao.values();
	}
	
	public List<Estado> listEstados(){
		return er.listEstados();
	}
	

}
