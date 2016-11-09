package br.com.sweetmanu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import br.com.sweetmanu.dao.UsuarioDao;
import br.com.sweetmanu.models.Role;
import br.com.sweetmanu.models.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UserDetailsService, UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios =
				manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email).getResultList();

		if (usuarios.isEmpty())
			throw new UsernameNotFoundException("Usuário '" + email + "', não encontrado!");

		return usuarios.get(0);
	}

	@Override
	public void salvarUsuario(Usuario usuario) {
		usuario.addRole(Role.ROLE_CLIENTE);
		String senha = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
		usuario.setSenha(senha);
		manager.persist(usuario);
	}

}
