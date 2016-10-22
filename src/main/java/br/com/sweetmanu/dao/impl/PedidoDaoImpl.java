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

	public void salvar(Pedido pedido) {
		manager.persist(pedido);
	}

	public void remover(Pedido pedido) {
		manager.remove(pedido);
	}

	public void atualizar(Pedido pedido) {
		manager.merge(pedido);
	}

	public void enviarPedido(Pedido pedido) {
		pedido.setStatus(PedidoStatus.ENVIADO);
		salvar(pedido);
	}

	public void confirmaPedido(Pedido pedido) {
		if (pedido.getCliente().getId() != null) {
			Pedido pedidoAConfirmar = findById(pedido.getId());
			if (pedidoAConfirmar != null) {
				pedidoAConfirmar.setStatus(PedidoStatus.CONFIRMADO);
				salvar(pedidoAConfirmar);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}
	}

	public void pedidoEntregue(Pedido pedido) {

		if (pedido.getCliente().getId() != null) {
			Pedido pedidoEntregue = findById(pedido.getId());
			if (pedidoEntregue != null) {
				pedidoEntregue.setStatus(PedidoStatus.ENTREGUE);
				salvar(pedidoEntregue);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}

	}

	public void pedidoEmPreparo(Pedido pedido) {

		if (pedido.getCliente().getId() != null) {
			Pedido pedidoEntregue = findById(pedido.getId());
			if (pedidoEntregue != null) {
				pedidoEntregue.setStatus(PedidoStatus.EM_PREPARO);
				salvar(pedidoEntregue);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}
	}

	public void pedidoFinalizado(Pedido pedido) {

		if (pedido.getCliente().getId() != null) {
			Pedido pedidoEntregue = findById(pedido.getId());
			if (pedidoEntregue != null) {
				pedidoEntregue.setStatus(PedidoStatus.FINALIZADO);
				salvar(pedidoEntregue);
			} else {
				System.out.println("Pedido não encontrado!");
			}
		}
	}
}
