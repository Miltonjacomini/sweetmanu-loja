package br.com.sweetmanu.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sweetmanu.dao.ProdutoTipoDao;
import br.com.sweetmanu.models.ProdutoTipo;

@Controller
@RequestMapping("/produtoTipo")
@Transactional
public class ProdutoTipoController {

	@Autowired
	private ProdutoTipoDao produtoTipoDao;

	@RequestMapping("/form")
	public ModelAndView form(ProdutoTipo produtoTipo) {
		return new ModelAndView("produtoTipo/form-add");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid ProdutoTipo produtoTipo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(produtoTipo);
		}
		produtoTipoDao.salvar(produtoTipo);
		return new ModelAndView("redirect:/produtoTipo");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produtoTipo/form-update");
		modelAndView.addObject("produtoTipo", produtoTipoDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("produtoTipo/list");
		modelAndView.addObject("paginatedList", produtoTipoDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		produtoTipoDao.remover(id);
		return "redirect:/produtoTipo";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView atualizar(@PathVariable("id") Integer id, @Valid ProdutoTipo produtoTipo,
			BindingResult bindingResult) {
		produtoTipo.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("produtoTipo/form-update");
		}
		produtoTipoDao.atualizar(produtoTipo);
		return new ModelAndView("redirect:/produtoTipo");
	}
}
