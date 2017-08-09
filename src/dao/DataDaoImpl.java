package dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import model.*;

public class DataDaoImpl implements DataDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void setSessionFactory (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addEntity(Javascript item) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
		
		return false;
	}
	
	@Override
	public Javascript getEntityByName(String name) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Javascript item = new Javascript();
		String hql = "from Javascript where exampleName = :name";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			item = (Javascript) query.uniqueResult();
			tx.commit();
			session.close();			
		} catch (Exception e) {
			tx.rollback();
			session.close();
		}
		
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Javascript> getEntityList() {
		session = sessionFactory.openSession();
		List<Javascript> itemList = new ArrayList <Javascript>();
		itemList = session.createQuery("From model.Javascript").list();
		
		return itemList;
	}

}
