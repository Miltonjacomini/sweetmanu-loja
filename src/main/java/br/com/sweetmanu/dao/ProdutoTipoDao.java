package br.com.sweetmanu.dao;

import java.util.List;

import br.com.sweetmanu.models.PaginatedList;
import br.com.sweetmanu.models.ProdutoTipo;

public interface ProdutoTipoDao {

	public List<ProdutoTipo> all();

	public void salvar(ProdutoTipo produtoTipo);

	public ProdutoTipo findById(Integer id);

	public void remover(ProdutoTipo produtoTipo);
	
	public void atualizar(ProdutoTipo produtoTipo);

	public PaginatedList paginated(int page, int max);

}
