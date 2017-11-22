package isamm.projet.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.isamm.entities.Filiere;
import com.isamm.entities.LigneMatiereFiliere;
import com.isamm.entities.Matiere;

import isamm.projet.inter.IDAO;

public class LigneMatiereFiliereService extends IDAO<LigneMatiereFiliere> {
	public LigneMatiereFiliereService(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public boolean getById(int id) {
		session = sessionFactory.openSession();
		LigneMatiereFiliere LigneMatiereFiliere = session.get(LigneMatiereFiliere.class, id);
		session.close();
		if (LigneMatiereFiliere.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean create(LigneMatiereFiliere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
		return true;
	}

	public boolean delete(LigneMatiereFiliere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(obj);
		tx.commit();
		return true;
	}

	public boolean update(int id, LigneMatiereFiliere obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		return true;
	}

	public List<LigneMatiereFiliere> getALL() {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from LigneMatiereFiliere");
		List LigneMatiereFilieres = q.list();
		return LigneMatiereFilieres;
	}

	public List<Matiere> getFiliere(Filiere filiere) {
		session = sessionFactory.openSession();
		Query q = session.createQuery(
				"select distinct l.matiere from LigneMatiereFiliere l " + "where l.filiere =:filiere");
		q.setParameter("filiere", filiere);
		List matieres = q.list();
		return matieres;
	}
}
