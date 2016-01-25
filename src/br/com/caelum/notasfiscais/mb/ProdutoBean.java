package br.com.caelum.notasfiscais.mb;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;

	private ProdutoDao dao = new ProdutoDao();

	public void grava() {
		this.dao.adiciona(this.produto);
		this.produto = new Produto();

		this.produtos = this.dao.listaTodos();
	}

	public Produto getProduto() {
		return this.produto;
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = this.dao.listaTodos();
		}

		return this.produtos;
	}

	public BigDecimal getTotalProdutos() {
		BigDecimal total = BigDecimal.ZERO;
		for (Produto produto : this.produtos) {
			total = total.add(BigDecimal.valueOf(produto.getPreco()));
		}
		return total;
	}

}
