package br.com.sweetmanu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/produto/detalhe/**").permitAll()
		.antMatchers("/carrinho/**").permitAll()
		.antMatchers("/produto-fotos/**").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/tags/**").permitAll()
		.antMatchers("/loja").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/produto/**").hasRole("ADMIN")
		.antMatchers("/pessoa/**").hasRole("ADMIN")
		.antMatchers("/categoria/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
