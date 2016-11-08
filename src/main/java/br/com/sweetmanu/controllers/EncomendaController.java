package br.com.sweetmanu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sweetmanu.dao.PedidoDao;

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
	
}
