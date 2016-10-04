package br.com.sweetmanu.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.sweetmanu.loja.models.PaginatedList;
import br.com.sweetmanu.loja.models.Categoria;

@Repository
public class CategoriaDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Categoria> all()
   {
      return manager.createQuery("select c from Categoria c", Categoria.class).getResultList();
   }

   public void salvar(Categoria categoria)
   {
      manager.persist(categoria);
   }

   public Categoria findById(Integer id)
   {
      return manager.find(Categoria.class, id);
   }

   public void remover(Categoria categoria)
   {
      manager.remove(categoria);
   }

   public void atualizar(Categoria categoria)
   {
      manager.merge(categoria);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Categoria.class, page, max);
   }

}
