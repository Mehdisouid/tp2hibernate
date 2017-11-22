package com.isamm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idEtudiant")
public class Etudiant extends Personne {
	private String cne;
	private Filiere filiere;
	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String cne) {
		super();
		this.cne = cne;
	}
	@ManyToOne(targetEntity = com.isamm.entities.Filiere.class)
	@JoinColumn(name = "id", nullable = true)
	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
			return "Etudiant [nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", email=" + this.getEmail() + ", sexe=" + this.getSexe() + ", telephone="
					+ this.getTelephone() + ", cne=" + cne + "]";
		}
	
	
	
}
