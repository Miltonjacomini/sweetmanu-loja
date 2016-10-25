package br.com.sweetmanu.dao;

import java.util.List;

import br.com.sweetmanu.models.PaginatedList;
import br.com.sweetmanu.models.Pessoa;

public interface PessoaDao {

	public List<Pessoa> all();

	public void salvar(Pessoa pessoa);

	public Pessoa findById(Integer id);
	
	public void remover(Integer id);

	public void atualizar(Pessoa pessoa);

	public PaginatedList paginated(int page, int max);
	
}
