package br.com.sweetmanu.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFailureHandlerSweetmanu implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException ex) throws IOException, ServletException {
		
		
		if(ex.getMessage().contains("Bad credentials"))
			request.setAttribute("messageError", "Usuário ou Senha inválidos, tente novamente.");
		else
			request.setAttribute("messageError", ex.getMessage());
		
		request.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request, response);;
		ex.printStackTrace();
	}

}
