package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *  Classe que implementa l'objecte ICONA
 * @author Gemma Rica
 *
 */


@Entity
@Table(name="icona")
public class Icona implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private Integer posicio;
	
	@Lob
	private Blob foto;
	
	
	@JsonIgnoreProperties(value={"icones","hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Panell panell;
	


	public Panell getPanell() {
		return panell;
	}

	public void setPanell(Panell panell) {
		this.panell = panell;
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

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public Integer getPosicio() {
		return posicio;
	}

	public void setPosicio(Integer posicio) {
		this.posicio = posicio;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
