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

import br.com.sweetmanu.loja.models.Categoria;
import br.com.sweetmanu.loja.daos.CategoriaDao;

@Controller
@RequestMapping("/categoria")
@Transactional
public class CategoriaController
{

   @Autowired
   private CategoriaDao categoriaDao;

   @RequestMapping("/form")
   public ModelAndView form(Categoria categoria)
   {
      ModelAndView modelAndView = new ModelAndView("categoria/form-add");
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView salvar(@Valid Categoria categoria, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(categoria);
      }
      categoriaDao.salvar(categoria);
      return new ModelAndView("redirect:/categoria");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("categoria/form-update");
      modelAndView.addObject("categoria", categoriaDao.findById(id));
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("categoria/list");
      modelAndView.addObject("paginatedList", categoriaDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remover/{id}")
   public String remover(@PathVariable("id") Integer id)
   {
      Categoria categoria = categoriaDao.findById(id);
      categoriaDao.remover(categoria);
      return "redirect:/categoria";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Categoria categoria, BindingResult bindingResult)
   {
      categoria.setId(id);
      if (bindingResult.hasErrors())
      {
         return new ModelAndView("categoria/form-update");
      }
      categoriaDao.atualizar(categoria);
      return new ModelAndView("redirect:/categoria");
   }
}
