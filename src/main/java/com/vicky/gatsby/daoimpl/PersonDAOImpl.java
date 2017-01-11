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

@Repository("PersonDAO")
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public PersonDAOImpl(SessionFactory sessionFactory) {
System.out.println("connect to DB");
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Persondetails person) {
		try {
			sessionFactory.getCurrentSession().save(person);
			System.out.println("daoimpl");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

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
