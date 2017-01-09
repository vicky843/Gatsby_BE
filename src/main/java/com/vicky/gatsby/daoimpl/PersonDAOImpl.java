package com.vicky.gatsby.daoimpl;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;
@Repository("PersonDAO")
public class PersonDAOImpl  implements PersonDAO{

	@Autowired
	public SessionFactory sessionFactory;
	
	 public PersonDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory=sessionFactory;
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

}
