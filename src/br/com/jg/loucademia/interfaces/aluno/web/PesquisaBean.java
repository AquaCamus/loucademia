package br.com.jg.loucademia.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jg.loucademia.application.service.AlunoService;
import br.com.jg.loucademia.domain.aluno.Aluno;

@Named
@RequestScoped
public class PesquisaBean implements Serializable {
	private String matricula;
	private String nome;
	private Integer rg;
	private Integer telefone;
	
	private List<Aluno> alunos;
	
	@EJB
	private AlunoService as;
	
	@Inject
	private AlunoBean ab;
	
	public String pesquisar() {
		alunos = as.listAlunos(matricula, nome, rg, telefone);
		return null;
	}
	
	public String excluir(String matricula) {
		as.excluir(matricula);
		return null;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
}
