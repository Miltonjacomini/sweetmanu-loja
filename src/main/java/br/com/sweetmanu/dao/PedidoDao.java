package br.com.sweetmanu.dao;

import java.util.List;

import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.PedidoStatus;

public interface PedidoDao {

	public List<Pedido> all();

	public Pedido findById(Integer id);

	public List<Pedido> findByStatus(PedidoStatus status);
	
	public List<Pedido> findByPessoa(Integer pessoaId);

	public void salvar(Pedido pedido);

	public void remover(Integer id);

	public void atualizar(Pedido pedido);

	public void enviarPedido(Pedido pedido);

	public boolean confirmaPedido(Integer pedidoId);

	public boolean pedidoEntregue(Integer pedidoId);

	public boolean pedidoEmPreparo(Integer pedidoId);

	public boolean pedidoFinalizado(Integer pedidoId);

	public boolean cancelar(Pedido pedido);

}
