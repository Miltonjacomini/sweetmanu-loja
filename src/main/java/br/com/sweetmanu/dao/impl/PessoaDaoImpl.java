package br.com.sweetmanu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sweetmanu.dao.PaginatorQueryHelper;
import br.com.sweetmanu.dao.PessoaDao;
import br.com.sweetmanu.models.PaginatedList;
import br.com.sweetmanu.models.Pessoa;
import br.com.sweetmanu.models.Role;

@Transactional
@Repository("pessoaDao")
public class PessoaDaoImpl implements PessoaDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Pessoa> all() {
		return manager.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
	}

	public void salvar(Pessoa pessoa) {
		pessoa.getUsuario().addRole(Role.ROLE_CLIENTE);
		manager.persist(pessoa);
	}

	public Pessoa findById(Integer id) {
		return manager.find(Pessoa.class, id);
	}

	public Pessoa findByEmail(String email) {
		return manager.createQuery("select p from Pessoa p where p.usuario.email = :email", Pessoa.class)
				   	  .setParameter("email", email).getSingleResult();
	}
	
	public void remover(Integer id) {
		manager.remove(findById(id));
	}

	public void atualizar(Pessoa pessoa) {
		manager.merge(pessoa);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Pessoa.class, page, max);
	}

}
