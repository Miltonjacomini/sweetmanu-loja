package br.com.sweetmanu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sweetmanu.dao.PedidoDao;
import br.com.sweetmanu.dao.PessoaDao;
import br.com.sweetmanu.infra.EmailSender;
import br.com.sweetmanu.infra.UsuarioUtils;
import br.com.sweetmanu.models.CarrinhoCompras;
import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.PedidoStatus;
import br.com.sweetmanu.models.Pessoa;
import br.com.sweetmanu.models.Usuario;
import br.com.sweetmanu.service.PedidoService;

@Transactional
@Service(value = "pedidoService")
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private PedidoDao pedidoDao;

	@Autowired
	private PessoaDao pessoaDao;

	@Override
	public boolean enviarPedido(CarrinhoCompras carrinho) throws RuntimeException {

		Usuario user = UsuarioUtils.getUsuario();
		if (user != null) {
			Pessoa pessoa = pessoaDao.findByEmail(user.getEmail());
			if (pessoa.getContato() != null) {
				Pedido pedido = new Pedido(pessoa);
				pedido = addProdutosPedido(pedido, carrinho);
				pedidoDao.enviarPedido(pedido);
				emailSender.emailPedidoEnviado(pedido);
				return true;
			} else
				throw new RuntimeException(
						"Usuario não tem dados de contato cadastrados, favor preencher na aba 'Dados Pessoais' em Minha Conta.");

		} else
			throw new RuntimeException("Usuario não está logado!");

	}

	private Pedido addProdutosPedido(Pedido pedido, CarrinhoCompras carrinho) {
		
		carrinho.getItens().forEach(p -> {
			pedido.addProduto(p, carrinho.getQuantidade(p));
		});

		return pedido;
	}

	public boolean cancelarPedido(Integer id) {
		Pedido pedido = pedidoDao.findById(id);
		if (pedido != null) {
			if (pedido.getStatus().equals(PedidoStatus.ENVIADO) || pedido.getStatus().equals(PedidoStatus.CONFIRMADO)) {
				if (pedidoDao.cancelar(pedido)) {
					emailSender.emailPedidoCancelado(pedido);
					return true;
				} else
					throw new RuntimeException("Não foi possivel localizar seu pedido, entre em contato conosco!");
			} else
				throw new RuntimeException(
						"Seu pedido não pode mais ser cancelado, ele já está em preparo!! Entre em contato conosco!");
		} else
			throw new RuntimeException("Não foi possivel localizar seu pedido, entre em contato conosco!");
	}

}
