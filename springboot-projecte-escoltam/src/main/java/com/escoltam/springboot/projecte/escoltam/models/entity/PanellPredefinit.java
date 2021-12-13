package com.escoltam.springboot.projecte.escoltam.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "panellpredefinit")
public class PanellPredefinit implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private Integer posicio;
	
	@JsonIgnoreProperties(value={"panellPredefinit","hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "panellPredefinit", cascade= CascadeType.ALL)
	private List<Icona> icones;
	
	
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


	private static final long serialVersionUID = 0L;
}
