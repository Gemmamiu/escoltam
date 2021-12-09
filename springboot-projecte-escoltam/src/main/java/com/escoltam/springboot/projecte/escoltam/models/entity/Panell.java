package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *  Classe que implementa l'objecte PANELL
 * @author Gemma Rica
 *
 */

@Entity
@Table(name = "panell")
public class Panell implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private Integer posicio;
	
	@Column(columnDefinition = "Boolean default false", nullable = false)
	private boolean favorit;
	
	@JsonIgnoreProperties(value={"panell","hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "panell", cascade= CascadeType.ALL)
	private List<Icona> icones;
	
	@JsonIgnoreProperties(value={"panells","hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuari usuari;

	

	//Constructor per inicialitzar un ArrayList de icones
	public Panell() {
		this.icones = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPosicio() {
		return posicio;
	}

	public void setPosicio(Integer posicio) {
		this.posicio = posicio;
	}

	public List<Icona> getIcones() {
		return icones;
	}

	public void setIcones(List<Icona> icones) {
		this.icones = icones;
	}
	
	
	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}


	public boolean isFavorit() {
		return favorit;
	}

	public void setFavorit(boolean favorit) {
		this.favorit = favorit;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
