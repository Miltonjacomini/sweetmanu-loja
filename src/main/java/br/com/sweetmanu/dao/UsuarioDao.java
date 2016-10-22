package br.com.sweetmanu.dao;

import br.com.sweetmanu.models.Usuario;

public interface UsuarioDao {

	public Usuario loadUserByUsername(String email);
	
}
