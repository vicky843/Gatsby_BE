package com.vicky.gatsby.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

@Repository
//@Transactional//it's good way of praticing this.
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public PersonDAOImpl(SessionFactory sessionFactory) {
System.out.println("connect to DB");
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Persondetails person) {
		sessionFactory.getCurrentSession().save(person);
			System.out.println("daoimpl");
			return true;
		
	}

	@Transactional
	public boolean update(Persondetails person) {
		// TODO Auto-generated method stub

		try {
			sessionFactory.getCurrentSession().update(person);
			System.out.println("update daoimpl");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Persondetails getid(String id) {
		
		Persondetails per=(Persondetails) sessionFactory.getCurrentSession().get(Persondetails.class,id);
		return per;
	}
	@Transactional
	public List<Persondetails> getperlist() {
		String hql="from Persondetails ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);

		System.out.println("listdaoimpl");
		System.out.println("query"+hql);
		@SuppressWarnings("unchecked")
		List<Persondetails> perid=query.list();
		System.out.println(hql+"this is perimp"+perid);
			return perid;
	
	}
/*	//should be removed after applying security
	
	public Persondetails login(String username, String password) {
		
	String hql="from Persondetails where username='"+username+"' password='"+password+"'";	
	System.out.println(hql);
	Query q=sessionFactory.getCurrentSession().createQuery(hql);
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	System.out.println("loginquery"+hql);
	Persondetails ps=(Persondetails) query.uniqueResult();
	
		return ps;
	}
*/
	@Transactional
	public Persondetails login(Persondetails person) {
		String username=person.getUsername();
		String password=person.getPassword();
		String hql="from Persondetails where username='"+username+"' and password='"+password+"'";	
		System.out.println(hql);
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("loginquery"+hql);
		Persondetails ps=(Persondetails) query.uniqueResult();
		
			return ps;
	}

	

/*	public boolean delete(String id) {
		try {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().delete(id);
			return true;
		} catch (Exception e) {
			System.out.println("exception in delete ");

			return false;

		}
	}*/

}
