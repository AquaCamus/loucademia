package br.com.jg.loucademia.domain.aluno;

import java.time.Year;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class AlunoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void store(Aluno aluno) {
		em.persist(aluno);
	}
	
	public void update(Aluno aluno) {
			em.merge(aluno);
	}
	
	public Aluno findByMatricula(String matricula) {
		return em.find(Aluno.class, matricula);
	}
	
	//Precisa estar selecionado
	public void delete(String matricula) {
		Aluno aluno = findByMatricula(matricula);
		
		if(aluno != null) {
			em.remove(aluno);
		}
	}
	
	public String getMaxMatriculaAno() {
		return em.createQuery("SELECT MAX(a.matricula) FROM Aluno a WHERE a.matricula LIKE :ano", String.class)
				.setParameter("ano", Year.now() + "%").getSingleResult();
	}
	
	public Aluno findByRg(Integer rg) {
		try {
			return em.createQuery("SELECT a FROM Aluno a WHERE a.rg = :rg", Aluno.class)
					.setParameter("rg", rg).getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Aluno>findByName(String nome) {
			return em.createQuery("SELECT a FROM Aluno a WHERE a.nome LIKE :nome", Aluno.class)
					.setParameter("nome", "%" + nome + "%").getResultList();
	}
}
