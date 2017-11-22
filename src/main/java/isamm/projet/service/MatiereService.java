package isamm.projet.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.isamm.entities.Matiere;

import isamm.projet.inter.IDAO;

public class MatiereService extends IDAO<Matiere> {
	public MatiereService(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public boolean getById(int id) {
		session = sessionFactory.openSession();
		Matiere matiere = session.get(Matiere.class, id);
		session.close();
		if (matiere.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public Matiere findById(int id) {
		session = sessionFactory.openSession();
		Matiere matiere = session.get(Matiere.class, id);
		session.close();
		return matiere;
	}

	public boolean create(Matiere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
		return true;
	}

	public boolean delete(Matiere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(obj);
		tx.commit();
		session.close();
		return true;
	}

	public boolean update(int id,Matiere obj) {
		
		session = sessionFactory.openSession();
		obj.setId(id);
		tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		session.close();
		return true;
	}
	public List<Matiere> getALL() {
			session = sessionFactory.openSession();
			Query q = session.createQuery("from Matiere");
			List matieres = q.list();
			return matieres;
	}
	public Matiere findByLibelle(String Libelle) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("select m from Matiere m " + "where m.libelle =:libelle");
        q.setParameter("libelle",Libelle);
        Matiere matiere=(Matiere) q.getSingleResult();
		session.close();
		return matiere;
	}
	
}
