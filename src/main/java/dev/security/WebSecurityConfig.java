package dev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	 @Value("${jwt.cookie}")
	  private String TOKEN_COOKIE;

	@Autowired
	  JWTAuthorizationFilter jwtAuthorizationFilter;
	
	@Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf().disable()
		.authorizeRequests()
		
		.antMatchers(HttpMethod.GET, "/collegues").permitAll()
		
		.antMatchers("/h2-console/**").permitAll()
		
		.antMatchers("/auth").permitAll()
	
		
		.anyRequest().authenticated()
		
		.and().headers().frameOptions().disable()
		
		.and()
	      
		.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
		.logout()
	      // en cas de succès un OK est envoyé (à la place d'une redirection vers /login)
	     .logoutSuccessHandler((req, resp, auth) -> resp.setStatus(HttpStatus.OK.value()))
	      // suppression du cookie d'authentification
	     .deleteCookies(TOKEN_COOKIE); // Gestion de la déconnexion
	
	}
	
	

}
