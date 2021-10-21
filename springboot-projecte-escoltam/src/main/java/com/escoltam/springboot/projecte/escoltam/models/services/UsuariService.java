package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IUsuariDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;

/**
 * Per fer la autenticació amb JPA
 * @author Gemma Rica
 *
 */
@Service
public class UsuariService implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UsuariService.class);
	
	@Autowired
	private IUsuariDao usuariDao;
	
	//El username és el correu de l'usuari
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuari usuari = usuariDao.findByUsername(username);
		
		//Control errors
		if(usuari == null) {
			logger.error("Error al Login: L'usuari amb correu '"+username+"' no existeix");
			throw new UsernameNotFoundException("Error al Login: L'usuari amb correu '"+username+"' no existeix");
		}
		
		//Obtenir llista de rols d'usuari
		List<GrantedAuthority> authorities = usuari.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuari.getUsername(), usuari.getPassword(), 
				usuari.getEnabled(), true, true, true, authorities);
		
	}

}
