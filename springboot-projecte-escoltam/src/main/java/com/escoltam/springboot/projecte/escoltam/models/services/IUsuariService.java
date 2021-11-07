package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari.Voice;

/**
 * On li donarem els mètodes del CRUD
 * @author Gemma Rica
 *
 */
public interface IUsuariService {

	/**
	 * LLISTAR usuaris
	 * @return llista d'usuaris (List)
	 */
	public List<Usuari> findAll();
	
	/**
	 * LLISTAR usuaris per pagina
	 * @return Usuari
	 */
	public Page<Usuari> findAll(Pageable pageable);
	
	/**
	 * CERCAR usuaris per username
	 * @param username
	 * @return Usuari
	 */
	public Usuari findByUsername(String username);
	
	/**
	 * AFEGIR usuari en la taula usuaris
	 * @param usuari
	 * @return L'objecte usuari creat
	 */
	public Usuari save(Usuari usuari);
	
	/**
	 * LLISTAR rols
	 * @return Llistat de rols
	 */
	public List<Role> findAllRoles();
	
	/**
	 * LLISTAT d'usuaris amb la VEU passada com a parametre
	 * @param voice veu
	 * @return Llistat d'usuaris amb la veu escollida.
	 */
	public List<Usuari> listAll(Voice voice);
	
	/**
	 * LLISTAT d'usuaris amb el rol passat com a parametre
	 * @param role_name nom del rol
	 * @return Llistat d'usuaris segons el rol.
	 */
	public List<Usuari>listAll(String role_name);
	
	public void delete(String username);

	
}
