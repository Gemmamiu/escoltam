package com.escoltam.springboot.projecte.escoltam.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Encarregat de donar acces als clients als recursos de l'app
 * @author Gemma Rica
 *
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/signin").permitAll()
		.antMatchers(HttpMethod.GET,"/api/usuaris","/api/usuaris/roles").hasRole("ADMIN")
		.anyRequest().authenticated();
		
	}

	
}
