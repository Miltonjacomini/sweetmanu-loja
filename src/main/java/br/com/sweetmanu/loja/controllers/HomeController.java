package br.com.sweetmanu.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sweetmanu.loja.daos.ProdutoDao;

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
}
