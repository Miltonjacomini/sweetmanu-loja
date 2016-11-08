package br.com.sweetmanu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sweetmanu.dao.ProdutoDao;
import br.com.sweetmanu.models.CarrinhoCompras;
import br.com.sweetmanu.models.Produto;
import br.com.sweetmanu.service.PedidoService;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	private ProdutoDao produtoDao;

	@Autowired
	private CarrinhoCompras carrinho;

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/adiciona/{id}", method = RequestMethod.GET)
	public ModelAndView adiciona(@PathVariable("id") Integer produtoId) {
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		carrinho.adicionar(produtoDao.findById(produtoId));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView itens() {
		return new ModelAndView("carrinho/itens");
	}

	@RequestMapping(value = "/remover/{id}", method = RequestMethod.GET)
	public ModelAndView remover(@PathVariable("id") Integer produtoId) {
		Produto produto = new Produto();
		produto.setId(produtoId);
		carrinho.remover(produto);
		return new ModelAndView("redirect:/carrinho");
	}

	@RequestMapping(value = "/enviarPedido", method = RequestMethod.GET)
	public ModelAndView enviarPedido(RedirectAttributes redirectAttributes) {

		try {
			if (pedidoService.enviarPedido(carrinho)) {
				redirectAttributes.addFlashAttribute("messageSuccess", "Seu pedido foi enviado! :) Obaa!");
				carrinho = new CarrinhoCompras();
			} else
				redirectAttributes.addFlashAttribute("messageWarning",
						"Vixi, tivemos algum problema no envio, tenta denovo mais tarde! :)");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("messageError", e.getMessage());
		}

		return new ModelAndView("redirect:/");
	}

}
