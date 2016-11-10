package br.com.sweetmanu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.sweetmanu.dao.PedidoDao;
import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.PedidoStatus;

@Repository("pedidoDao")
public class PedidoDaoImpl implements PedidoDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Pedido> all() {
		return manager.createQuery("select distinct p from Pedido p JOIN FETCH p.produtos", Pedido.class)
				.getResultList();
	}

	public Pedido findById(Integer id) {
		return manager.find(Pedido.class, id);
	}

	public List<Pedido> findByPessoa(Integer pessoaId) {
		return manager.createQuery(
				"select distinct p from Pedido p JOIN FETCH p.produtos where p.pessoa.id = :id and p.status != 'CANCELADO'",
				Pedido.class).setParameter("id", pessoaId).getResultList();
	}

	public List<Pedido> findByStatus(PedidoStatus status) {
		return manager.createQuery("select p from Pedido p where p.status = :status", Pedido.class)
				.setParameter("status", status).getResultList();
	}

	public void salvar(Pedido pedido) {
		manager.persist(pedido);
	}

	public void remover(Integer id) {
		manager.remove(findById(id));
	}

	public void atualizar(Pedido pedido) {
		manager.merge(pedido);
	}

	public void enviarPedido(Pedido pedido) {
		pedido.setStatus(PedidoStatus.ENVIADO);
		salvar(pedido);
	}

	public boolean confirmaPedido(Integer pedidoId) {
		if (pedidoId != null) {
			Pedido pedidoAConfirmar = findById(pedidoId);
			if (pedidoAConfirmar != null && pedidoAConfirmar.getStatus().equals(PedidoStatus.ENVIADO)) {
				pedidoAConfirmar.setStatus(PedidoStatus.CONFIRMADO);
				salvar(pedidoAConfirmar);
				return true;
			} else
				throw new RuntimeException("Pedido não encontrado ou status diferente de 'ENVIADO'!");
		}
		return false;
	}

	public boolean pedidoEntregue(Integer pedidoId) {

		if (pedidoId != null) {
			Pedido pedidoEntregue = findById(pedidoId);
			if (pedidoEntregue != null && pedidoEntregue.getStatus().equals(PedidoStatus.FINALIZADO)) {
				pedidoEntregue.setStatus(PedidoStatus.ENTREGUE);
				salvar(pedidoEntregue);
				return true;
			} else
				throw new RuntimeException("Pedido não encontrado ou status diferente de 'FINALIZADO'!");
		}
		
		return false;
	}

	public boolean pedidoEmPreparo(Integer pedidoId) {

		if (pedidoId != null) {
			Pedido pedidoEntregue = findById(pedidoId);
			if (pedidoEntregue != null && pedidoEntregue.getStatus().equals(PedidoStatus.CONFIRMADO)) {
				pedidoEntregue.setStatus(PedidoStatus.EM_PREPARO);
				salvar(pedidoEntregue);
				return true;
			} else
				throw new RuntimeException("Pedido não encontrado ou status diferente de 'CONFIRMADO'!");
		}
		return false;
	}

	public boolean pedidoFinalizado(Integer pedidoId) {

		if (pedidoId != null) {
			Pedido pedidoFinalizado = findById(pedidoId);
			if (pedidoFinalizado != null && pedidoFinalizado.getStatus().equals(PedidoStatus.EM_PREPARO)) {
				pedidoFinalizado.setStatus(PedidoStatus.FINALIZADO);
				salvar(pedidoFinalizado);
				return true;
			} else
				throw new RuntimeException("Pedido não encontrado ou status diferente de 'EM PREPARO'!");
		}
		return false;
	}

	@Override
	public boolean cancelar(Pedido pedido) {
		pedido.setStatus(PedidoStatus.CANCELADO);
		salvar(pedido);
		return true;
	}

}
