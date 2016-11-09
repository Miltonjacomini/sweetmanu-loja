package br.com.sweetmanu.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import br.com.sweetmanu.models.Role;
import br.com.sweetmanu.models.Usuario;

@Component
public class AuthenticationSucessHandlerSweetmanu implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		if (authentication.getPrincipal() instanceof Usuario) {
			final Usuario user = (Usuario) authentication.getPrincipal();
			if (user.getAuthorities().contains(Role.ROLE_ADMIN))
				response.sendRedirect(request.getContextPath()+"/indexAdmin");
			else 
				response.sendRedirect(request.getContextPath()+"/minhaConta");
		} 

	}

}
