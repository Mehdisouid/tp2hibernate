package isamm.projet.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.isamm.entities.Formateur;
import com.isamm.entities.Matiere;

import isamm.projet.inter.IDAO;

public class FormateurService extends IDAO<Formateur> {
	public FormateurService(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public boolean getById(int id) {
		session = sessionFactory.openSession();
		Formateur matiere = session.get(Formateur.class, id);
		session.close();
		if (matiere.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public Formateur findById(int id) {
		session = sessionFactory.openSession();
		Formateur formateur = session.get(Formateur.class, id);
		session.close();
		return formateur;
	}

	public boolean create(Formateur obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		return true;
	}

	public boolean delete(Formateur obj) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(obj);
		tx.commit();
		return true;
	}

	public boolean update(int id, Formateur obj) {

		session = sessionFactory.openSession();
		obj.setIdPersonne(id);
		tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		return true;
	}

	public List<Formateur> getALL() {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from Formateur");
		List matieres = q.list();
		return matieres;
	}

	public List<Formateur> getFormateurByMatiere(Matiere matiere) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("select m.formateur from Matiere m" + " where m.id=:idmatiere ");
		q.setParameter("idmatiere", matiere.getId());
		List matieres = q.list();
		return matieres;
	}

}
