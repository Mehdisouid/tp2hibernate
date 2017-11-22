package isamm.projet.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;

import com.isamm.entities.Etudiant;
import com.isamm.entities.Filiere;
import com.isamm.entities.Formateur;
import com.isamm.entities.Matiere;

import isamm.projet.inter.IDAO;

public class FiliereService extends IDAO<Filiere> {
	public FiliereService(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public boolean getById(int id) {
		session = sessionFactory.openSession();
		Filiere Filiere = session.get(Filiere.class, id);
		session.close();
		if (Filiere.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean create(Filiere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		return true;
	}

	public boolean delete(Filiere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(obj);
		tx.commit();
		return true;
	}

	public boolean update(int id, Filiere obj) {

		session = sessionFactory.openSession();
		obj.setId(id);
		tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		return true;
	}

	public List<Filiere> getALL() {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from Filiere");
		List Filieres = q.list();
		return Filieres;
	}

	public Filiere findById(int id) {
		session = sessionFactory.openSession();
		Filiere filiere = session.get(Filiere.class, id);
		session.close();
		return filiere;
	}
	
	public Filiere findByCode(String code) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("select f from Filiere f " + "where f.code =:code");
        q.setParameter("code",code);
        Filiere filiere=(Filiere) q.getSingleResult();
		session.close();
		return filiere;
	}


}
