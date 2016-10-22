package br.com.sweetmanu.dao;

import java.util.List;

import br.com.sweetmanu.models.Pedido;

public interface PedidoDao {

	public List<Pedido> all();

	public Pedido findById(Integer id);

	public void salvar(Pedido pedido);

	public void remover(Pedido pedido);

	public void atualizar(Pedido pedido);

	public void enviarPedido(Pedido pedido);

	public void confirmaPedido(Pedido pedido);

	public void pedidoEntregue(Pedido pedido);

	public void pedidoEmPreparo(Pedido pedido);

	public void pedidoFinalizado(Pedido pedido);
	
}
