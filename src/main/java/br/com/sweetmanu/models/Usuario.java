package br.com.sweetmanu.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SENHA")
	private String senha;

	@Transient
	private String senhaConfirma;

	@ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	private Collection<Role> permissoes = new ArrayList<Role>();

	public Usuario(){
	}

	public Usuario(Usuario usuario, Role role){
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.senhaConfirma = usuario.getSenhaConfirma();
		addRole(role);
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void addRole(Role role) {
		this.permissoes.add(role);
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	public String getSenhaConfirma() {
		return senhaConfirma;
	}

	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	public boolean isSenhaEquals() {
		if (!StringUtils.isEmpty(senha) && !StringUtils.isEmpty(senhaConfirma)) {
			if (senha.equals(senhaConfirma))
				return true;
		}
		throw new RuntimeException("A senha não é compativel ou está vazia!");
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissoes;
	}
}
