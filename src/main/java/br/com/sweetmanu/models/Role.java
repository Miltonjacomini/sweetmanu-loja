package br.com.sweetmanu.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

	ROLE_ADMIN,
	ROLE_CLIENTE;
	
	
	@Override
	public String getAuthority() {
		return name();
	}
}
