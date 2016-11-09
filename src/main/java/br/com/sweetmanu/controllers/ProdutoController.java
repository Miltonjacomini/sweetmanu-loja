package br.com.sweetmanu.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.sweetmanu.dao.ProdutoDao;
import br.com.sweetmanu.dao.ProdutoTipoDao;
import br.com.sweetmanu.models.Produto;
import br.com.sweetmanu.service.AwsS3Service;
import br.com.sweetmanu.validation.PaginatedListValidation;
import br.com.sweetmanu.validation.ProdutoValidation;

@Controller
@Transactional
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoDao productDao;
	@Autowired
	private AwsS3Service service;
	@Autowired
	private ProdutoTipoDao produtoTipoDao;

	@InitBinder("produto")
	public void InitBinderProduto(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}

	@InitBinder("paginatedList")
	public void InitBinderPaginatedList(WebDataBinder binder) {
		binder.addValidators(new PaginatedListValidation());
	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produto/form-add");
		return carregarDependencias(modelAndView);
	}

	private ModelAndView carregarDependencias(ModelAndView modelAndView) {
		modelAndView.addObject("tipoProdutoList", produtoTipoDao.all());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(MultipartFile foto, @Valid Produto produto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(produto);
		}
		String nomeFoto = produto.getNome()+foto.getOriginalFilename().substring(foto.getOriginalFilename().indexOf("."),
				foto.getOriginalFilename().length()).replaceAll(" ", "");
		service.uploadFile(foto, nomeFoto);
		produto.setPathFoto(nomeFoto);
		productDao.salvar(produto);

		return new ModelAndView("redirect:/produto");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produto/form-update");
		modelAndView.addObject("produto", productDao.findById(id));
		carregarDependencias(modelAndView);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("produto/list");
		modelAndView.addObject("paginatedList", productDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		productDao.remover(id);
		return "redirect:/produto";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView atualizar(@PathVariable("id") Integer id, @Valid Produto produto, BindingResult bindingResult) {
		produto.setId(id);
		if (bindingResult.hasErrors()) {
			return carregarDependencias(new ModelAndView("produto/form-update"));
		}
		productDao.atualizar(produto);
		return new ModelAndView("redirect:/produto");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produto/detalhe");
		modelAndView.addObject("produto", productDao.findById(id));
		carregarDependencias(modelAndView);
		return modelAndView;
	}
	
}
