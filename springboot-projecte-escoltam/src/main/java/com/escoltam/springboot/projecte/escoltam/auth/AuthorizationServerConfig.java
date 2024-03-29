package com.escoltam.springboot.projecte.escoltam.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Classe que s'encarrega del proces de l'autentificacióde oauth2.
 * Tot el que té a veure amb el Token, crear login, crear el token, validar-lo...
 * @author Gemma Rica
 *
 */

/**
 * Metode per configurar el servidor
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	/**
	 * Configuració dels PERMISOS dels endpoints
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.tokenKeyAccess("permitAll()") // Qui pot accedir (tothom)
				.checkTokenAccess("isAuthenticated"); // Validar token

	}

	/**
	 * Configuració dels CLIENTS(Aplicacions) --> Registrar clients per ID i contrasenya
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient("androidapp") //Client ANDROID
				.secret(passwordEncoder.encode("12345")) // password
				.scopes("read", "write") // permisos del client
				.authorizedGrantTypes("password", "refresh_token") // Com obtenir el token (amb credencials)
				.accessTokenValiditySeconds(3600) // Validesa token (1h)
				.refreshTokenValiditySeconds(3600) // Temps renovar validesa token (1h)
				.and()
				.withClient("desktopapp") //Client DESKTOP
				.secret(passwordEncoder.encode("12345"))
				.scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(3600)
				.refreshTokenValiditySeconds(3600);
	}


	/**
	 * Configuració dels ENDPOINTS --> Proces de autenticació i validació token
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.authenticationManager(authenticationManager)
				.tokenStore(tokenStore())
				.accessTokenConverter(accessTokenConverter());
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		//jwtAccessTokenConverter.setSigningKey(JwtConfig.SECRET_KEY);
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);// Clau que firma
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC); // Clau que verifica
		return jwtAccessTokenConverter;
	}

}
