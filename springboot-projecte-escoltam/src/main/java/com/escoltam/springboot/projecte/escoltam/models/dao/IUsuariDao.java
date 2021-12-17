package com.escoltam.springboot.projecte.escoltam.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari.Voice;


/**
 * Classe per accedir, fer consulta, etc... a la BD.
 * CrudRepository --> implementa mètodes de consulta (Taula que fem la cerca, tipus de dada)
 * @author Gemma Rica
 *
 */
public interface IUsuariDao extends JpaRepository<Usuari, Long>{
	
	/**
	 * Buscar per email (username)
	 * @param username
	 * @return usuari
	 */
	public Usuari findByUsername (String username);
	
	//prova, funciona igual que l'anterior
	@Query("select u from Usuari u left join fetch u.panells where u.username=?1")
	public Usuari findByUsername2 (String username);
	
	/**
	 * LListar roles
	 * @return llista de roles
	 */
	@Query("from Role")
	public List<Role> findAllRoles();
	
	/**
	 * Llistar usuaris segons la veu escollida
	 * @param voice veu
	 * @return Llistat d'usuaris
	 */
	@Query("select u from Usuari u where u.voice like :#{#voice}")
	public List<Usuari> findByVoice(@Param("voice") Voice voice);
	
	/**
	 * Llistar usuaris segons rol
	 * @param role_name nom del rol
	 * @return Llistat d'usuaris
	 */
	@Query("select u from Usuari u join u.roles r where r.name like :#{#roleName}")
	public List<Usuari> findByRole(@Param("roleName") String role_name);
	
	@Modifying
	@Query("delete from Usuari u where u.username=?1")
	public void deleteByUsername(String username);
}
