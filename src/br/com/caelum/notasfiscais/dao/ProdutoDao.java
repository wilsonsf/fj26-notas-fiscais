package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.notasfiscais.modelo.Produto;

public class ProdutoDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void adiciona(Produto produto) {
		//persiste o objeto
		this.manager.persist(produto);
	}


	public void remove(Produto produto) {
		this.manager.remove(this.manager.merge(produto));
	}

	public void atualiza(Produto produto) {
		this.manager.merge(produto);
	}

	public List<Produto> buscaPorNome(String nome) {
		String jpql = "select p from Produto p where "
				+ " lower(p.nome) like :nome order by p.nome";

		return this.manager.createQuery(jpql, Produto.class)
				.setParameter("nome", nome + "%").getResultList();
	}

	public List<Produto> listaTodos() {
		CriteriaQuery<Produto> query = this.manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));

		return this.manager.createQuery(query).getResultList();
	}

	public Produto buscaPorId(Long id) {
		return this.manager.find(Produto.class, id);
	}
}