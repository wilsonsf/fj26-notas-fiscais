package br.com.caelum.notasfiscais.mb;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Stereotype
@ViewScoped
@Named
@Target({ TYPE })
@Retention(RUNTIME)
public @interface ViewModel { }
