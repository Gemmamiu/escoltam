package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="panellPredefinit")
public class PanellPredefinit{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private Integer posicio;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="panellPredefinit_id")
	private List<Icona> icones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="panellPredefinit", cascade= CascadeType.ALL)
	private List<Usuari> usuaris;
	
	public PanellPredefinit() {
		icones = new ArrayList<>();
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

	public List<Usuari> getUsuaris() {
		return usuaris;
	}

	public void setUsuaris(List<Usuari> usuaris) {
		this.usuaris = usuaris;
	}

	
	
}
