package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String campoTexto = new String();

	public String pseudoGrava() {
		this.campoTexto = new String();
		return null;
	}

	public String getCampoTexto() {
		return this.campoTexto;
	}

	public void setCampoTexto(String campoTexto) {
		this.campoTexto = campoTexto;
	}
}
