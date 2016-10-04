package br.com.sweetmanu.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.sweetmanu.loja.models.PaginatedList;
import br.com.sweetmanu.loja.models.Produto;

@Repository
public class ProdutoDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Produto> all()
   {
      return manager.createQuery("select p from Produto p", Produto.class).getResultList();
   }

   public void salvar(Produto produto)
   {
      manager.persist(produto);
   }

   public Produto findById(Integer id)
   {
      return manager.find(Produto.class, id);
   }

   public void remover(Produto produto)
   {
      manager.remove(produto);
   }

   public void atualizar(Produto produto)
   {
      manager.merge(produto);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Produto.class, page, max);
   }

}
