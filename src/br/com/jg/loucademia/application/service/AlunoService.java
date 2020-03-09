package br.com.jg.loucademia.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.jg.loucademia.application.utils.StringUtils;
import br.com.jg.loucademia.application.utils.Validation;
import br.com.jg.loucademia.domain.aluno.Aluno;
import br.com.jg.loucademia.domain.aluno.AlunoRepository;

@Stateless
public class AlunoService {
	
	@EJB
	private AlunoRepository ar;
	
	public void createOrUpdate(Aluno aluno) {
		if(StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		}
		else {
			update(aluno);
		}
	}
	
	private void create(Aluno aluno ) {
		Validation.assertNotEmpty(aluno);
		Validation.rgRepetido(ar.findByRg(aluno.getRg()));
		
		aluno.gerarMatricula(ar.getMaxMatriculaAno());
		ar.store(aluno);

	}
	
	private void update(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		ar.update(aluno);
	}
	
	public void excluir(String matricula) {
		if(!StringUtils.isEmpty(matricula)) {
			ar.delete(matricula);
		}
	}
	
	public Aluno findByMatricula(String matricula) {
		return ar.findByMatricula(matricula);		
	}
	
	public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone){	
		List<Aluno> alunos = new ArrayList<>();
		if(!StringUtils.isEmpty(matricula)){
			Aluno aluno = ar.findByMatricula(matricula);
			alunos.add(aluno);
		}
		
		if(!StringUtils.isEmpty(nome)){
			alunos = ar.findByName(nome);
		}
		
		if(rg != null) {
			Aluno aluno = ar.findByRg(rg);
			alunos.add(aluno);
		}
		
		return alunos;
	}
}
