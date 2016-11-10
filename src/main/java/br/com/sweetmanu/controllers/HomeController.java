package br.com.sweetmanu.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sweetmanu.dao.ProdutoDao;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDao productDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("produtos", productDao.all());
		return modelAndView;
	}
	
	@RequestMapping("/indexAdmin")
	public String indexAdmin() {
		return "indexAdmin";
	}
	
	@RequestMapping("/sobreNos")
	public String sobreNos() {
		return "sobreNos";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public ModelAndView acessoNegado(Principal user) {
		ModelAndView model = new ModelAndView("403");

		if (user != null) {
			model.addObject("errorMessage", "Olá, " + user.getName() + ",\n Você não pode acessar essa pagina do site!");
		} else {
			model.addObject("errorMessage", "Olá,\n Você não pode acessar essa pagina do site!");
		}
		
		return model;
	}
	
}
