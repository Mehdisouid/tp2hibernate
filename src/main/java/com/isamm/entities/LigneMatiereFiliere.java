package com.isamm.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class LigneMatiereFiliere {

	@Embeddable
	public static class Id implements Serializable {
		@Column(name = "idMatiere")
		private Integer idMatiere;
		@Column(name = "idFiliere")
		private Integer idFiliere;
		public Id() {
		}
		public Id(Integer idMatiere, Integer idFiliere) {
			super();
			this.idMatiere = idMatiere;
			this.idFiliere = idFiliere;
			}
	}
	@EmbeddedId
	private Id id = new Id();
	
	@Column(name = "masseHoraire")
	private String masseHoraire;
	
	@ManyToOne
	@JoinColumn(name = "idMatiere", insertable = false, updatable = false)
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "idFiliere", insertable = false, updatable = false)
	private Filiere filiere;
	
	public String getMasseHoraire() {
		return masseHoraire;
	}
	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public void setMasseHoraire(String masseHoraire) {
		this.masseHoraire = masseHoraire;
	}
	public LigneMatiereFiliere(String masseHoraire, Matiere matiere, Filiere filiere) {
		this.masseHoraire = masseHoraire;
		this.matiere = matiere;
		this.filiere = filiere;
		this.id.idMatiere = matiere.getId();
		this.id.idFiliere = filiere.getId();
	}
	@Override
	public String toString() {
		return "LigneMatiereFiliere [masseHoraire=" + masseHoraire + "]";
	}
	
	
	
}
