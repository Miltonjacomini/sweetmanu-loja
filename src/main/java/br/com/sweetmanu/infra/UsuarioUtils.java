package br.com.sweetmanu.infra;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.sweetmanu.models.Usuario;

public class UsuarioUtils {
	
	public static Usuario getUsuario(){
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Usuario){
			return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}else
			return null;
	}
	
}
