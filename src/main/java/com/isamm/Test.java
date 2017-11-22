package com.isamm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.isamm.entities.Etudiant;
import com.isamm.entities.Filiere;
import com.isamm.entities.Formateur;
import com.isamm.entities.LigneMatiereFiliere;
import com.isamm.entities.Matiere;

import isamm.projet.service.EtudiantService;
import isamm.projet.service.FiliereService;
import isamm.projet.service.FormateurService;
import isamm.projet.service.LigneMatiereFiliereService;
import isamm.projet.service.MatiereService;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		MatiereService matiereservice = new MatiereService(sessionFactory);
		FiliereService filiereservice = new FiliereService(sessionFactory);
		EtudiantService etudiantservice = new EtudiantService(sessionFactory);
		FormateurService formateureservice = new FormateurService(sessionFactory);
		LigneMatiereFiliereService lignematierefiliereservice = new LigneMatiereFiliereService(sessionFactory);
		
		Filiere f1 = new Filiere("IAII", "Ingénierie des automatismes et informatique industrielle");
		Filiere f2 = new Filiere("IRT", "Ingénierie des réseaux et télécommunications");
		Filiere f3 = new Filiere("IIR", "Ingénierie informatique et réseaux");
		filiereservice.create(f1);
		filiereservice.create(f2);
		filiereservice.create(f3);
		
		Matiere m1 =new Matiere("TPC", "Techniques de programmation structurée");
		Matiere m2 =new Matiere("JB", "Java de Base");
		Matiere m3 =new Matiere("AU", "Administration Unix");
		Matiere m4 =new Matiere("Hibernate", "Framework de persistance");
		Matiere m5 =new Matiere("POO", "Programmation orientée objet");
		Matiere m6 = new Matiere("Cc", "Cloud Computing");
		
		matiereservice.create(m1);
		matiereservice.create(m2);
		matiereservice.create(m3);
		matiereservice.create(m4);
		matiereservice.create(m5);
		matiereservice.create(m6);
		
		Formateur fo1 = new Formateur();
		fo1.setNom("Yahia");
		fo1.setPrenom("limani");
		fo1.setSexe("M");
		fo1.setEmail("Yahiaslimani@gmail.com");
		fo1.setMatricule("SI");
		formateureservice.create(fo1);
		m6.setFormateur(fo1);
		matiereservice.update(m6.getId(), m6);
		m1.setFormateur(fo1);
		matiereservice.update(m1.getId(), m1);
		
		Formateur fo2 = new Formateur();
		fo2.setNom("Safia");
		fo2.setPrenom("ilham");
		fo2.setSexe("F");
		fo2.setEmail("Safiailham@gmail.com");
		fo2.setMatricule("IS");
		formateureservice.create(fo2);
		m3.setFormateur(fo2);
		matiereservice.update(m3.getId(), m3);
		m5.setFormateur(fo2);
		matiereservice.update(m5.getId(), m5);
		

		Etudiant e1 =new Etudiant();
		e1.setNom("SAFI");
		e1.setPrenom("AMAL");
		e1.setSexe("F");
		e1.setCne("22845676");
		e1.setFiliere(f3);
		etudiantservice.create(e1);
		
		Etudiant e2 =new Etudiant();
		e2.setNom("Alami");
		e2.setPrenom("Samir");
		e2.setSexe("M");
		e2.setCne("23845976");
		e2.setFiliere(f1);
		etudiantservice.create(e2);
		
		Etudiant e3 =new Etudiant();
		e3.setNom("Alaoui");
		e3.setPrenom("Safa");
		e3.setSexe("F");
		e3.setCne("22345476");
		e3.setFiliere(f1);
		etudiantservice.create(e3);
	
		
	
		 
		try {
			LigneMatiereFiliere lignematierefiliere1=new LigneMatiereFiliere("50", m1, f1);
			LigneMatiereFiliere lignematierefiliere2=new LigneMatiereFiliere("30", m2, f1);
			LigneMatiereFiliere lignematierefiliere3=new LigneMatiereFiliere("20", m3, f1);
			LigneMatiereFiliere lignematierefiliere4=new LigneMatiereFiliere("10", m4, f2);
			LigneMatiereFiliere lignematierefiliere5=new LigneMatiereFiliere("10", m5, f3);
			lignematierefiliereservice.create(lignematierefiliere1);
			lignematierefiliereservice.create(lignematierefiliere2);
			lignematierefiliereservice.create(lignematierefiliere3);
			lignematierefiliereservice.create(lignematierefiliere4);
			lignematierefiliereservice.create(lignematierefiliere5);
			
		
			System.out.println("Liste des formateurs par matieres");
			List<Formateur> l  = formateureservice.getFormateurByMatiere(m5);
			Iterator i = l.iterator();
			while (i.hasNext()) {
			System.out.println(((Formateur) i.next()).toString());
			}
			
			System.out.println("Liste des etudiants par filiere");
			
			List<Etudiant> le  = etudiantservice.getEtudiantFiliere(f1);
			Iterator ie = le.iterator();
			while (ie.hasNext()) {
			System.out.println(((Etudiant) ie.next()).toString());
			
			}
			System.out.println("Liste des matieres par filiere");
			List<Matiere> lm  = lignematierefiliereservice.getFiliere(f1);
			Iterator im = lm.iterator();
			while (im.hasNext()) {
			System.out.println(((Matiere) im.next()).toString());
			
			}
			
			
			
			
		} catch (Exception e) {

		}
		
		
	}
		
}
