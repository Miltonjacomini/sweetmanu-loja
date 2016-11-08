package br.com.sweetmanu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/produto/detalhe/**").permitAll()
		.antMatchers("/carrinho/enviarPedido").hasRole("CLIENTE")
		.antMatchers("/carrinho/**").permitAll()
		.antMatchers("/minhaConta/cadastro/**").permitAll()
		.antMatchers("/minhaConta/recuperarSenha/**").permitAll()
		.antMatchers("/minhaConta/**").hasRole("CLIENTE")
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/tags/**").permitAll()
		.antMatchers("/loja").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/indexAdmin").hasRole("ADMIN")
		.antMatchers("/produto/**").hasRole("ADMIN")
		.antMatchers("/pessoa/**").hasRole("ADMIN")
		.antMatchers("/produtoTipo/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin()
		.loginPage("/login").permitAll()
		.successHandler(successHandler())
		.failureHandler(authenticationFailureHandler())
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.and()
		.exceptionHandling().accessDeniedPage("/403");

	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new AuthenticationFailureHandlerSweetmanu();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() throws Exception {
		return new AuthenticationSucessHandlerSweetmanu();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
