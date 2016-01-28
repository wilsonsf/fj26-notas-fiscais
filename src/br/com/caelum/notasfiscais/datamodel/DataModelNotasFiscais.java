package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NotaFiscalDao dao;

	@PostConstruct
	void inicilizaTotal() {
		super.setRowCount(this.dao.contaTodos());
	}

	@Override
	public List<NotaFiscal> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		return this.dao.listaTodosPaginada(first, pageSize);
//		return super.load(first, pageSize, sortField, sortOrder, filters);
	}
}
