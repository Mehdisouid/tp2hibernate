package com.isamm.entities;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libelle;
	@OneToMany(mappedBy = "matiere")
	private Set<LigneMatiereFiliere> ligneMatiereFiliere = new HashSet<LigneMatiereFiliere>();
	
	@ManyToOne
	private Formateur formateur;
	
	

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matiere(int id, String code, String libelle, Set<LigneMatiereFiliere> ligneMatiereFiliere,
			Formateur formateur) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.ligneMatiereFiliere = ligneMatiereFiliere;
		this.formateur = formateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<LigneMatiereFiliere> getLigneMatiereFiliere() {
		return ligneMatiereFiliere;
	}

	public void setLigneMatiereFiliere(Set<LigneMatiereFiliere> ligneMatiereFiliere) {
		this.ligneMatiereFiliere = ligneMatiereFiliere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Matiere [code=" + code + ", libelle=" + libelle  + "]";
	}

	
	
	
	
	
	
}
