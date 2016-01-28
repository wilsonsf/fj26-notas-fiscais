package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;

@ConversationModel
public class NotaFiscalBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;
	@Inject
	private NotaFiscalDao notaFiscalDao;
	@Inject
	private ProdutoDao produtoDao;

	private Long idProduto;
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();

	public String avanca() {
		if(this.conversation.isTransient()) {
			this.conversation.setTimeout(1000*60*3); // 1s > 1min > 10min
			this.conversation.begin();
		}
		return "item?faces-redirect=true";
	}

	@Transactional
	public String grava() {
		this.notaFiscalDao.adiciona(this.notaFiscal);
		this.notaFiscal = new NotaFiscal();

		this.conversation.end();

		return "notafiscal?faces-redirect=true";
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

	public String getDataFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.notaFiscal.getData().getTime());
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
