package br.com.sweetmanu.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sweetmanu.dao.PedidoDao;

@Transactional
@Controller
@RequestMapping("encomenda")
public class EncomendaController {

	@Autowired
	private PedidoDao pedidoDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView("encomenda/home");
		modelAndView.addObject("encomendas", pedidoDao.all());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/confirma/{pedidoId}")
	public ModelAndView confirmar(@ModelAttribute("pedidoId") Integer pedidoId, RedirectAttributes model){

		try {
			if(!pedidoDao.confirmaPedido(pedidoId)){
				model.addFlashAttribute("messageWarning",
						"Tivemos algum problema ao confirmar o pedido, entre em contato com o suporte!");
			}else
				model.addFlashAttribute("messageSuccess", "O pedido foi alterado para 'Confirmado' com sucesso.");
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addFlashAttribute("messageError", e.getMessage());
		}
		
		return new ModelAndView("redirect:/encomenda");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/emPreparo/{pedidoId}")
	public ModelAndView emPreparo(@ModelAttribute("pedidoId") Integer pedidoId, RedirectAttributes model){

		try {
			if(!pedidoDao.pedidoEmPreparo(pedidoId)){
				model.addFlashAttribute("messageWarning",
						"Tivemos algum problema, entre em contato com o suporte!");
			}else
				model.addFlashAttribute("messageSuccess", "O pedido foi alterado para 'Em Preparo' com sucesso.");
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addFlashAttribute("messageError", e.getMessage());
		}
		
		return new ModelAndView("redirect:/encomenda");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/finalizado/{pedidoId}")
	public ModelAndView finalizado(@ModelAttribute("pedidoId") Integer pedidoId, RedirectAttributes model){

		try {
			if(!pedidoDao.pedidoFinalizado(pedidoId)){
				model.addFlashAttribute("messageWarning",
						"Tivemos algum problema ao finalizar o pedido, entre em contato com o suporte!");
			}else
				model.addFlashAttribute("messageSuccess", "O pedido foi alterado para 'Finalizado' com sucesso.");
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addFlashAttribute("messageError", e.getMessage());
		}
		
		return new ModelAndView("redirect:/encomenda");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/entregue/{pedidoId}")
	public ModelAndView entregue(@ModelAttribute("pedidoId") Integer pedidoId, RedirectAttributes model){

		try {
			if(!pedidoDao.pedidoEntregue(pedidoId)){
				model.addFlashAttribute("messageWarning",
						"Tivemos algum problema, entre em contato com o suporte!");
			}else
				model.addFlashAttribute("messageSuccess", "O pedido foi alterado para 'Entregue' com sucesso!!");
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addFlashAttribute("messageError", e.getMessage());
		}
		
		return new ModelAndView("redirect:/encomenda");
	}
	
}
