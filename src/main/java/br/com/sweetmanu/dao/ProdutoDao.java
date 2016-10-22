package br.com.sweetmanu.dao;

import java.util.List;

import br.com.sweetmanu.models.PaginatedList;
import br.com.sweetmanu.models.Produto;

public interface ProdutoDao {

	public List<Produto> all();

	public void salvar(Produto produto);

	public Produto findById(Integer id);
	
	public void remover(Integer id);

	public void atualizar(Produto produto);

	public PaginatedList paginated(int page, int max);

}
