package br.com.sast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.sast.service.UsuarioServiceImpl;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	
	/* Responsável pelo gerenciamento de autenticação da aplicação. 
	 É através desse método que sabemos quem são os usuários da aplicação e suas senhas */
	
	/* Método responsável por buscar os usuários da minha aplicação através de um service */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth
		.inMemoryAuthentication()
		.withUser("fulano")
		.password("123")
		.roles("USER");*/
		
		auth.userDetailsService(usuarioService)
		.passwordEncoder(passwordEncoder());
		
	}
	
	/* Método responsável por retornar a confiração realizada no método acima */
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors()
	.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	

}
