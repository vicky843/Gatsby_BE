package com.vicky.gatsby.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.gatsby.dao.BlogDAO;
import com.vicky.gatsby.model.Blogdetails;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		System.out.println("connect to DB");
				this.sessionFactory = sessionFactory;
			}
	
	public boolean save(Blogdetails blog) {
	try {
		sessionFactory.getCurrentSession().save(blog);
		System.out.println("saveblog");
		return true;
		
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
		
	}

	public boolean delete(Blogdetails blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			System.out.println("deleteblog");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}
	}

	public boolean update(Blogdetails blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			System.out.println("updateblog");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Blogdetails> bloglist() {
List<Blogdetails> listblog=(List<Blogdetails>)sessionFactory.getCurrentSession().createCriteria(Blogdetails.class).list();
		return listblog;
	}

	public Blogdetails getbyid(String blogid) {
	/*String hql="from Blogdetails where blogid='"+blogid+"'"*/;
	Blogdetails blo=(Blogdetails) sessionFactory.getCurrentSession().get(Blogdetails.class, blogid);
	return blo;
	}

}
