package isamm.projet.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.isamm.entities.Etudiant;
import com.isamm.entities.Filiere;
import com.isamm.entities.Formateur;
import com.isamm.entities.Matiere;

import isamm.projet.inter.IDAO;

public class EtudiantService extends IDAO<Etudiant> {
	public EtudiantService(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public boolean getById(int id) {
		session = sessionFactory.openSession();
		Etudiant matiere = (Etudiant) session.get(Etudiant.class, id);
		session.close();
		if (matiere.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean create(Etudiant obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
		return true;
	}

	public boolean delete(Etudiant obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(obj);
		tx.commit();
		session.close();
		return true;
	}

	public boolean update(int id,Etudiant obj) {
		
		session = sessionFactory.openSession();
		obj.setIdPersonne(id);
		tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		session.close();
		return true;
	}
	public List<Etudiant> getALL() {
			session = sessionFactory.openSession();
			org.hibernate.Query q = session.createQuery("from Etudiant");
			List matieres = q.list();
			return matieres;
	}
	
	public List<Etudiant> getEtudiantFiliere(Filiere filiere) {
		session = sessionFactory.openSession();
		org.hibernate.Query q = session.createQuery("select e from Etudiant e"
				+ " where e.filiere=:filiere ");
		q.setParameter("filiere",filiere);
		List etudiants = q.list();
		return etudiants;
}
	
	
}
