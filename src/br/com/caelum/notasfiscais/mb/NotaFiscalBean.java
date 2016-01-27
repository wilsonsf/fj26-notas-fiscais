package br.com.caelum.notasfiscais.mb;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@ViewScoped
public class NotaFiscalBean {

	@Inject
	private NotaFiscalDao notaFiscalDao;
	@Inject
	private ProdutoDao produtoDao;

	private Long idProduto;
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();

	public String grava() {
		this.notaFiscalDao.adiciona(this.notaFiscal);

		this.notaFiscal = new NotaFiscal();

		return null;
	}

	public void guardaItem() {
		Produto produto = this.produtoDao.buscaPorId(this.idProduto);

		this.item.setProduto(produto);
		this.item.setValorUnitario(produto.getPreco());

		this.notaFiscal.getItens().add(this.item);
		this.item.setNotaFiscal(this.notaFiscal);

		this.item = new Item();
		this.idProduto = null;

	}

	public NotaFiscal getNotaFiscal() {
		return this.notaFiscal;
	}

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
