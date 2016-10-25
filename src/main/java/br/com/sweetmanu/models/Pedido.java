package br.com.sweetmanu.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Pessoa pessoa;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<Produto>();

	@Enumerated(EnumType.STRING)
	private PedidoStatus status;

	public Pedido() {
	}

	public Pedido(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	/* GETTERS AND SETTERS */
	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", pessoa=" + pessoa + ", status=" + status + ", produtos=" + produtos + "]";
	}
}
