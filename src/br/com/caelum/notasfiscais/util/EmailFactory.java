package br.com.caelum.notasfiscais.util;

import javax.enterprise.inject.Produces;

public class EmailFactory {

	@Produces @EmailComercial
	private String emailComercial = "comercial@uberdist.com.br";
	@Produces @EmailFinanceiro
	private String emailFinanceiro = "financeiro@uberdist.com.br";

}
