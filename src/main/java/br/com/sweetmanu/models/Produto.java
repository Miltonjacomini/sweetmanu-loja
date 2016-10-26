package br.com.sweetmanu.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min=3, max=50)
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Size(min=3, max=200)
	@Column(name="DESCRICAO", nullable=false)
	private String descricao;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	private ProdutoTipo produtoTipo;

	@Column(name="PATH_FOTO")
	private String pathFoto;

	@NotNull
	@Column(name="VALOR", nullable=false)
	private BigDecimal valor;

	/* GETTERS AND SETTERS */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProdutoTipo getProdutoTipo() {
		return produtoTipo;
	}

	public void setProdutoTipo(ProdutoTipo produtoTipo) {
		this.produtoTipo = produtoTipo;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTotal(int quantidade) {
		return this.getValor().multiply(new BigDecimal(quantidade));
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
