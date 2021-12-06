package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Table;

/**
 * Classe que implementa l'objecte Usuari
 * 
 * @author Gemma Rica
 *
 */
@Entity
@Table(name = "usuari")
public class Usuari implements Serializable {

	public enum Voice {
		MALE, FEMALE;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// El username serà el correu de l'usuari

	@Column(name="username", unique = true, length = 50, nullable = false)
	private String username;

	@Column(length = 60)
	private String password;

	@Column(columnDefinition = "Boolean default false")
	private Boolean enabled;

	@Enumerated(EnumType.STRING)
	private Voice voice;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuari_role", joinColumns = @JoinColumn(name = "usuari_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuari_id", "role_id" }) })
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Role> roles;
	 
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "usuari", cascade= CascadeType.ALL)
	@JsonIgnoreProperties(value={"usuari","hibernateLazyInitializer", "handler"}, allowSetters=true)
	private List<Panell> panells;
		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="panellPredefinit_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PanellPredefinit panellPredefinit;

	
	
	public Usuari() {
		this.panells = new ArrayList<>();

	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	public PanellPredefinit getPanellPredefinit() {
		return panellPredefinit;
	}

	public void setPanellPredefinit(PanellPredefinit panellPredefinit) {
		this.panellPredefinit = panellPredefinit;
	}


	public List<Panell> getPanells() {
		return panells;
	}

	public void setPanells(List<Panell> panells) {
		this.panells = panells;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
