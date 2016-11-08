package br.com.sweetmanu.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Pessoa pessoa;

	@ManyToMany
	@JoinTable(name = "pedido_produtos", joinColumns = { @JoinColumn(name = "pedido_id") }, inverseJoinColumns = {
			@JoinColumn(name = "produto_id") })
	private List<Produto> produtos = new ArrayList<Produto>();

	@Enumerated(EnumType.STRING)
	private PedidoStatus status;

	@Column(name = "DT_CRIACAO")
	private LocalDate dtCriacao;

	public Pedido() {
		this.dtCriacao = LocalDate.now();
	}

	public Pedido(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.dtCriacao = LocalDate.now();
	}

	public void addProduto(Produto produto, int quantidade) {
		IntStream.range(0, quantidade).forEach( p -> {
			produtos.add(produto);
		});
	}

	public BigDecimal getValorTotal(List<Produto> produtos) {
		BigDecimal valorTotal = produtos.stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
		return valorTotal;
	}

	public Integer getQuantidadeProduto(Produto produto){
		int soma = 0;
		for(Produto pro : produtos){
			if(pro.getId() == produto.getId())
				soma++;
		}
		return soma;
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

	public LocalDate getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(LocalDate dtCriacao) {
		this.dtCriacao = dtCriacao;
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
