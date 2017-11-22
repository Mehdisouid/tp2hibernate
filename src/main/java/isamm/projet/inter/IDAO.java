package isamm.projet.inter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class IDAO<T> {
	protected SessionFactory sessionFactory = null;
	protected Transaction tx = null;
	protected Session session = null;

	public IDAO(SessionFactory sessionFactory){
	this.sessionFactory = sessionFactory;
	}
	
	public abstract boolean create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(int id ,T obj);
	public abstract boolean getById(int id);
	public abstract List<T> getALL();

}
