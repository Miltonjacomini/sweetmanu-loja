package br.com.sweetmanu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.sweetmanu.dao.PaginatorQueryHelper;
import br.com.sweetmanu.dao.ProdutoTipoDao;
import br.com.sweetmanu.models.PaginatedList;
import br.com.sweetmanu.models.ProdutoTipo;

@Repository("produtoTipoDao")
public class ProdutoTipoDaoImpl implements ProdutoTipoDao {

	@PersistenceContext
	private EntityManager manager;

	public List<ProdutoTipo> all() {
		return manager.createQuery("select p from ProdutoTipo p", ProdutoTipo.class).getResultList();
	}

	public void salvar(ProdutoTipo produtoTipo) {
		manager.persist(produtoTipo);
	}

	public ProdutoTipo findById(Integer id) {
		return manager.find(ProdutoTipo.class, id);
	}

	public void remover(ProdutoTipo produtoTipo) {
		manager.remove(produtoTipo);
	}

	public void atualizar(ProdutoTipo produtoTipo) {
		manager.merge(produtoTipo);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, ProdutoTipo.class, page, max);
	}

}
