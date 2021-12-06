package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name="icona")
public class Icona implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private Integer posicio;
	
	@Lob
	private Blob foto;
	
	private boolean favorit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="panell_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Panell panell;
	
	
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
