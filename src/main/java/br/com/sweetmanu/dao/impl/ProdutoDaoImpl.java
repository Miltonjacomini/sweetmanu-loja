package br.com.sweetmanu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.sweetmanu.dao.PaginatorQueryHelper;
import br.com.sweetmanu.dao.ProdutoDao;
import br.com.sweetmanu.models.PaginatedList;
import br.com.sweetmanu.models.Produto;

@Repository("produtoDao")
public class ProdutoDaoImpl implements ProdutoDao{

	@PersistenceContext
	private EntityManager manager;

	public List<Produto> all() {
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public void salvar(Produto produto) {
		manager.persist(produto);
	}

	public Produto findById(Integer id) {
		return manager.find(Produto.class, id);
	}

	public void remover(Integer id) {
		manager.remove(findById(id));
	}

	public void atualizar(Produto produto) {
		manager.merge(produto);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Produto.class, page, max);
	}

}
