package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="icona")
public class Icona implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private Integer posicio;
	
	@Lob
	private byte[] foto;
	
	private boolean favorits;
	
	@ManyToOne(fetch=FetchType.LAZY)
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Integer getPosicio() {
		return posicio;
	}

	public void setPosicio(Integer posicio) {
		this.posicio = posicio;
	}

	public boolean isFavorits() {
		return favorits;
	}

	public void setFavorits(boolean favorits) {
		this.favorits = favorits;
	}

	public Panell getPanell() {
		return panell;
	}

	public void setPanell(Panell panell) {
		this.panell = panell;
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
