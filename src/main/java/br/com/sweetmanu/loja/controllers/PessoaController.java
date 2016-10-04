package br.com.sweetmanu.loja.controllers;

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

import br.com.sweetmanu.loja.daos.PessoaDao;
import br.com.sweetmanu.loja.models.Pessoa;

@Controller
@RequestMapping("/pessoa")
@Transactional
public class PessoaController {

	@Autowired
	private PessoaDao pessoaDao;

	@RequestMapping("/form")
	public ModelAndView form(Pessoa pessoa) {
		ModelAndView modelAndView = new ModelAndView("pessoa/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		// modelAndView.addObject("categoryList", categoryDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Pessoa pessoa, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(pessoa);
		}
		pessoaDao.save(pessoa);
		return new ModelAndView("redirect:/pessoa");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("pessoa/form-update");
		modelAndView.addObject("pessoa", pessoaDao.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("pessoa/list");
		modelAndView.addObject("paginatedList", pessoaDao.paginated(page, 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Pessoa pessoa = pessoaDao.findById(id);
		pessoaDao.remove(pessoa);
		return "redirect:/pessoa";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Pessoa pessoa, 
			BindingResult bindingResult) {
		pessoa.setId(id);
		if (bindingResult.hasErrors()) {
			return loadFormDependencies(new ModelAndView("pessoa/form-update"));
		}
		
		pessoaDao.update(pessoa);
		return new ModelAndView("redirect:/pessoa");
	}
}
