package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDao dao;
	@Inject
	private UsuarioLogadoBean usuarioLogado;

	private Usuario usuario = new Usuario();

	public String efetuaLogin() {

		boolean loginValido = this.dao.existe(this.usuario);
		if (loginValido) {
			this.usuarioLogado.logar(this.usuario);
			return "produto?faces-redirect=true";
		} else {
			this.usuarioLogado.deslogar();
			limpaFormulario();
			return null;
		}
	}

	private void limpaFormulario() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

}
