package br.com.caelum.notasfiscais.dao;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class DaoFactory {

//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Produces
	public <T> Dao<T> createDao(InjectionPoint injection){
		ParameterizedType type = (ParameterizedType) injection.getType();

		Class classe = (Class) type.getActualTypeArguments()[0];

		return new Dao (classe);
	}

}
