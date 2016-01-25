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
		limpaFormularioDeProduto();

		atualizaListagemDeProdutos();
	}

	private void limpaFormularioDeProduto() {
		this.produto = new Produto();
	}

	public void remove(Produto produto) {
		this.dao.remove(produto);
		atualizaListagemDeProdutos();
	}

	private void atualizaListagemDeProdutos() {
		this.produtos = this.dao.listaTodos();
	}

	public Produto getProduto() {
		return this.produto;
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			atualizaListagemDeProdutos();
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
