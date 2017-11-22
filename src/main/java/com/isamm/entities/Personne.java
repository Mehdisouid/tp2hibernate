package com.isamm.entities;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personne")
public class Personne {
	
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom; 
	@Column(name = "email")
	private String email; 
	@Column(name = "sexe")
	private String sexe;
	@Column(name = "telephone")
	private String telephone;
	
	
	private int idPersonne;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", sexe=" + sexe + ", telephone="
				+ telephone + "]";
	}
	
	
}
