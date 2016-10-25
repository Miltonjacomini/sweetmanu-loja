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
		return manager.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}

	public Pedido findById(Integer id) {
		return manager.find(Pedido.class, id);
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

	public void confirmaPedido(Pedido pedido) {
		if (pedido.getPessoa().getId() != null) {
			Pedido pedidoAConfirmar = findById(pedido.getId());
			if (pedidoAConfirmar != null && pedidoAConfirmar.getStatus().equals(PedidoStatus.ENVIADO)) {
				pedidoAConfirmar.setStatus(PedidoStatus.CONFIRMADO);
				salvar(pedidoAConfirmar);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}
	}

	public void pedidoEntregue(Pedido pedido) {

		if (pedido.getPessoa().getId() != null) {
			Pedido pedidoEntregue = findById(pedido.getId());
			if (pedidoEntregue != null && pedidoEntregue.getStatus().equals(PedidoStatus.FINALIZADO)) {
				pedidoEntregue.setStatus(PedidoStatus.ENTREGUE);
				salvar(pedidoEntregue);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}

	}

	public void pedidoEmPreparo(Pedido pedido) {

		if (pedido.getPessoa().getId() != null) {
			Pedido pedidoEntregue = findById(pedido.getId());
			if (pedidoEntregue != null && pedidoEntregue.getStatus().equals(PedidoStatus.CONFIRMADO)) {
				pedidoEntregue.setStatus(PedidoStatus.EM_PREPARO);
				salvar(pedidoEntregue);
			} else {
				System.out.println("Pedido não encontrado ou não está confirmado!");
			}
		}
	}

	public void pedidoFinalizado(Pedido pedido) {

		if (pedido.getPessoa().getId() != null) {
			Pedido pedidoFinalizado = findById(pedido.getId());
			if (pedidoFinalizado != null && pedidoFinalizado.getStatus().equals(PedidoStatus.EM_PREPARO)) {
				pedidoFinalizado.setStatus(PedidoStatus.FINALIZADO);
				salvar(pedidoFinalizado);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}
	}
}
