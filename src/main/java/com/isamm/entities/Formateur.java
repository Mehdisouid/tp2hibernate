package com.isamm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idFormateur")
public class Formateur extends Personne {
	String matricule;

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formateur(String matricule, List<Matiere> matiere) {
		super();
		this.matricule = matricule;

	}
	public Formateur(String matricule) {
		this.matricule = matricule;
	}
	@Override
	public String toString() {
			return "Etudiant [nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", email=" + this.getEmail() + ", sexe=" + this.getSexe() + ", telephone="
					+ this.getTelephone() + ", matricule=" + matricule + "]";
		}
	
	
	
}
