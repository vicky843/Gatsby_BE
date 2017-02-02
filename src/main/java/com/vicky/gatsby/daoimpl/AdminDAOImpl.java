package com.vicky.gatsby.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.gatsby.dao.AdminDAO;
import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;
@Repository
public class AdminDAOImpl implements AdminDAO {

public SessionFactory sessionFactory;

@Autowired(required=true)
PersonDAO pers;
public AdminDAOImpl(SessionFactory sessionFactory)

{ 
	this.sessionFactory=sessionFactory;
}
@Transactional
	public Persondetails personroleupdate(String username, String role) {
		Persondetails per=(Persondetails) sessionFactory.getCurrentSession().get(Persondetails.class, username);
per.setRole(role);
		pers.update(per);
		return per;
	}
@Transactional
	public Persondetails personstatusupdate(String username, String status) {
	Persondetails per=(Persondetails) sessionFactory.getCurrentSession().get(Persondetails.class,username);
	per.setStatus(status);
	pers.update(per);
	return per;
	}

}
