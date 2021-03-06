package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import br.com.caelum.notasfiscais.modelo.Usuario;

@SessionModel
public class UsuarioLogadoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}

	public void deslogar() {
		this.usuario = null;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public boolean isLogado() {
		return this.usuario != null;
	}

}
