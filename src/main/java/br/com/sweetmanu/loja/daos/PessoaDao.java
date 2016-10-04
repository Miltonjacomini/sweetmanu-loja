package br.com.sweetmanu.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.sweetmanu.loja.models.PaginatedList;
import br.com.sweetmanu.loja.models.Pessoa;

@Repository
public class PessoaDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Pessoa> all()
   {
      return manager.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
   }

   public void save(Pessoa pessoa)
   {
      manager.persist(pessoa);
   }

   public Pessoa findById(Integer id)
   {
      return manager.find(Pessoa.class, id);
   }

   public void remove(Pessoa pessoa)
   {
      manager.remove(pessoa);
   }

   public void update(Pessoa pessoa)
   {
      manager.merge(pessoa);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Pessoa.class, page, max);
   }

}
