package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ViewModel
public class ListaNotasFiscaisBean {

	@Inject
	private NotaFiscalDao dao;

	private List<NotaFiscal> notasFiscais;

	public List<NotaFiscal> getNotasFiscais() {
		if(this.notasFiscais == null) {
			this.notasFiscais = this.dao.listaTodos();
		}

		return this.notasFiscais;
	}

}
