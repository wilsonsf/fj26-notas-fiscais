package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	@Inject
	private EntityManager manager;

	public Dao(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) {
		this.manager.persist(t);
	}

	public void remove(T t) {
		this.manager.remove(this.manager.merge(t));
	}

	public void atualiza(T t) {
		this.manager.merge(t);
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = this.manager.getCriteriaBuilder().createQuery(this.classe);
		query.select(query.from(this.classe));

		List<T> lista = this.manager.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Long id) {
		T instancia = this.manager.find(this.classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) this.manager.createQuery(
				"select count(n) from " + this.classe.getName() + " n")
				.getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = this.manager.getCriteriaBuilder().createQuery(this.classe);
		query.select(query.from(this.classe));

		List<T> lista = this.manager.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		return lista;
	}

}
