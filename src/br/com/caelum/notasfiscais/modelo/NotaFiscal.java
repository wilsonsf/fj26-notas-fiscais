package br.com.caelum.notasfiscais.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class NotaFiscal implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@CNPJ(message="CNPJ inválido")
//	@Pattern(regexp="\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}",message="CNPJ inválido")
	private String cnpj;

	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();

	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="notaFiscal")
	private List<Item> itens = new ArrayList<Item>();

	public BigDecimal getValorTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : this.itens) {
			total = total.add(BigDecimal.valueOf(item.getTotal()));
		}
		return total;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return this.itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
