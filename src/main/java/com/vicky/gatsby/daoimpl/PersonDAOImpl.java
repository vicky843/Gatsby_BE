package com.vicky.gatsby.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

public class PersonDAOImpl  implements PersonDAO{

	private SessionFactory sessionFactory;
	 public PersonDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}
	
	public boolean save(Persondetails person) {
try {
	sessionFactory.getCurrentSession().save(person);
	return true;
} catch (HibernateException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;
}
		
	}

	public boolean update(Persondetails person) {
		// TODO Auto-generated method stub
	
		try {
			sessionFactory.getCurrentSession().update(person);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
