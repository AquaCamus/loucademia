package br.com.jg.loucademia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.jg.loucademia.application.service.AlunoService;
import br.com.jg.loucademia.application.utils.StringUtils;
import br.com.jg.loucademia.domain.aluno.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable{

	@EJB
	private AlunoService as;
	
	@Inject
	private FacesContext fc;
	
	private Aluno aluno = new Aluno();
	
	private String matricula;
	
	private String titulo = "Novo Aluno";
	
	public String gravar() {
		as.createOrUpdate(aluno);
		fc.addMessage(null, new FacesMessage("Dados Alterados com Sucesso"));
		return null;
	}
	
	public String pesquisar() {
		as.findByMatricula(matricula);
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
		
	
	 public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void carregar() {
		 if(!StringUtils.isEmpty(matricula)) {
			 aluno = as.findByMatricula(matricula);
			 titulo = "Alterar Aluno";
		 }
	 }
}
