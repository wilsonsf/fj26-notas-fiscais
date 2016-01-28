package br.com.caelum.notasfiscais.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="Produto deve ter um nome válido")
	private String nome;

	private String descricao;

	@DecimalMin(value="0.01",message="Preço inválido")
	private Double preco;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
