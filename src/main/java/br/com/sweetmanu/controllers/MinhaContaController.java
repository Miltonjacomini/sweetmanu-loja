package br.com.sweetmanu.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sweetmanu.infra.ErrorUtils;
import br.com.sweetmanu.models.Pessoa;
import br.com.sweetmanu.service.MinhaContaService;
import br.com.sweetmanu.service.PedidoService;

@Controller
@RequestMapping("/minhaConta")
public class MinhaContaController {

	@Autowired
	private MinhaContaService minhaContaService;
	
	@Autowired
	private PedidoService pedidoService;

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		Pessoa pessoa = minhaContaService.dadosPessoais();
		modelAndView.addObject("pessoa", pessoa);
		modelAndView.addObject("pedidos", minhaContaService.meusPedidos(pessoa.getId()));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/recuperarSenha/{email}")
	public ModelAndView recuperarSenha(@PathVariable String email) {
		ModelAndView modelAndView = new ModelAndView("minhaConta/recuperarSenha");
		if (minhaContaService.recuperarSenha(email))
			modelAndView.addObject("messageSuccess", "Foi enviado um email pra você com sua senha! =)");
		else
			modelAndView.addObject("messageError",
					"Tivemos algum problema ao enviar seu e-mail, tente novamente mais tarde. :(");
		return modelAndView;
	}

	@RequestMapping("/cadastro")
	public ModelAndView cadastro() {
		return new ModelAndView("minhaConta/cadastro");
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView cadastro(@Valid Pessoa pessoa, BindingResult bindingResult, RedirectAttributes model) {
		ModelAndView modelAndView = new ModelAndView("minhaConta/cadastro");
		if (bindingResult.hasErrors() || !pessoa.getUsuario().isSenhaEquals()) {
			return ErrorUtils.retornaErrosNaView(bindingResult, modelAndView);
		}
		if (!minhaContaService.cadastrarNovoUsuario(pessoa))
			model.addFlashAttribute("messageWarning",
					"Tivemos algum problema ao enviar seu e-mail de boas vindas, entre em contato conosco!");

		model.addFlashAttribute("messageSuccess", "Seu cadastro foi feito, seja bem vinda (o)!!");

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView minhaConta() {
		ModelAndView modelAndView = new ModelAndView("minhaConta/principal");
		return loadFormDependencies(modelAndView);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView minhaContaAtualizaPessoa(@PathVariable("id") Integer id, @Valid Pessoa pessoa,
			BindingResult bindingResult) {
		ModelAndView modAndView = new ModelAndView("minhaConta/principal");
		pessoa.setId(id);

		if (bindingResult.hasErrors()) {
			return ErrorUtils.retornaErrosNaView(bindingResult, modAndView);
		}
		minhaContaService.atualizarCadastro(pessoa);
		return new ModelAndView("redirect:/minhaConta");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cancelarPedido/{id}")
	public ModelAndView cancelarPedido(@PathVariable("id") Integer id, RedirectAttributes model){
			
		if(!pedidoService.cancelarPedido(id))
			model.addFlashAttribute("messageWarning",
					"Tivemos algum problema ao cancelar seu pedido, entre em contato conosco!");

		model.addFlashAttribute("messageSuccess", "Seu pedido foi cancelado!!");

		return new ModelAndView("redirect:/minhaConta");
			
	}
	
}
