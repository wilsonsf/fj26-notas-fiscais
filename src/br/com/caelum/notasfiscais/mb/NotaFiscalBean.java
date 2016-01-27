package br.com.caelum.notasfiscais.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named
@RequestScoped
public class NotaFiscalBean {

	@Inject
	private NotaFiscalDao notaFiscalDao;

	private NotaFiscal notaFiscal = new NotaFiscal();

	public String grava() {
		this.notaFiscalDao.adiciona(this.notaFiscal);

		this.notaFiscal = new NotaFiscal();

		return null;
	}

	public NotaFiscal getNotaFiscal() {
		return this.notaFiscal;
	}

}
