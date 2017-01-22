package com.vicky.gatsby.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vicky.gatsby.dao.AdminDAO;
import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

public class AdminDAOImpl implements AdminDAO {
@Autowired
public SessionFactory sessionFactory;

@Autowired
PersonDAO pers;
public AdminDAOImpl(SessionFactory sessionFactory)

{ 
	this.sessionFactory=sessionFactory;
}
	public Persondetails personroleupdate(String username, String role) {
		Persondetails per=(Persondetails) sessionFactory.getCurrentSession().get(Persondetails.class, username);
per.setRole(role);
		pers.update(per);
		return per;
	}

	public Persondetails personstatusupdate(String username, String status) {
	Persondetails per=(Persondetails) sessionFactory.getCurrentSession().get(Persondetails.class,username);
	per.setStatus(status);
	pers.update(per);
	return per;
	}

}
