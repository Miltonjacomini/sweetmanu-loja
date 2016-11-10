package br.com.sweetmanu.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sweetmanu.dao.ProdutoDao;
import br.com.sweetmanu.infra.EmailSender;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDao productDao;
	
	@Autowired
	private EmailSender emailSender;
	
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
	
	@RequestMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/contato")
	public ModelAndView recuperarSenha(@ModelAttribute("nome") String nome, @ModelAttribute("email") String email, 
			@ModelAttribute("assunto") String assunto, @ModelAttribute("mensagem") String mensagem, RedirectAttributes model) {
		if (emailSender.emailContato(nome,email,assunto,mensagem)){
			model.addFlashAttribute("messageSuccess", "Seu e-mail foi enviado, agradecemos o contato! =)");
		}else
			model.addFlashAttribute("messageError",
					"Tivemos algum problema ao enviar seu e-mail, tente novamente mais tarde. :(");
		
		return new ModelAndView("redirect:/");
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
