
package br.com.sweetmanu.service;

import br.com.sweetmanu.models.CarrinhoCompras;

public interface PedidoService {

	public boolean enviarPedido(CarrinhoCompras carrinho) throws RuntimeException;
	
	public boolean cancelarPedido(Integer id);
}
