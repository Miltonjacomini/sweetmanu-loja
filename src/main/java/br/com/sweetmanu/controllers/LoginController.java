package br.com.sweetmanu.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sweetmanu.models.Usuario;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public ModelAndView loginFailure(RedirectAttributes model) {
		model.addFlashAttribute("error", "true");
		return new ModelAndView("redirect:login");
	}

	@SuppressWarnings("unused")
	private Usuario getPrincipal() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Usuario) {
			return (Usuario) principal;
		}
		return null;
	}
}
