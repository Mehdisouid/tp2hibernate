package com.isamm.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libelle;
	@OneToMany(mappedBy = "filiere")
	private Set<LigneMatiereFiliere> ligneMatiereFiliere = new HashSet<LigneMatiereFiliere>();

	public Filiere(int id, String code, String libelle, Set<LigneMatiereFiliere> ligneMatiereFiliere) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.ligneMatiereFiliere = ligneMatiereFiliere;
	}
	
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
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

	public Filiere(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	
	
	
}
