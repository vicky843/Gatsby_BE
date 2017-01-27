package com.vicky.gatsby.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vicky.gatsby.dao.FriendDAO;
import com.vicky.gatsby.model.Friend;

@Repository
public class FriendDAOImpl implements FriendDAO{
	@Autowired
	public SessionFactory sessionFactory;
	
	public FriendDAOImpl(SessionFactory sessionFactory) {
		System.out.println("connect to DB");
				this.sessionFactory = sessionFactory;
			}

	public boolean save(Friend friend){
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean update(Friend friend){
		try {
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}

	public List<Friend> getMyFriends(String username) {

		String hql ="from Friend where username='"+username+"'  and status='"+"A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> list= (List<Friend>) query.list();
		return list;
	}

	public Friend get(String username, String friendId) {
	String hql="from Friend where username ='"+username+"' and friendId='"+friendId+"'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list = (List<Friend>) query.list();
	if(list!=null && !list.isEmpty()){
		return list.get(0);
	}
	return null;
		
	}

	public void delete(String username, String friendId) {
		Friend friend =new Friend();
		friend.setFriendId(friendId);
		friend.setUsername(username); 
		sessionFactory.getCurrentSession().delete(friend);
		}

	public List<Friend> getNewFriendRequests(String friendId) {
		String hql="from Friend where friendId= " + "'" + friendId + "' and status = '"+ "N'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> list = (List<Friend>)query.list();
		return list;
	}

	public void setOnline(String friendId) {
		String hql="UPDATE Friend SET isOnline = 'Y' where friendId='"+friendId+"'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		}

	public void setOffLine(String friendId) {
		String hql="UPDATE Friend SET isOnline='N' where friendId='"+friendId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
	}


	public List<Friend> getMyFriend(String friendId) {
		String hql="from Friend where friendId= " + "'" + friendId + "' and status ='"+ "A'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> list = (List<Friend>)query.list();
		return list;

	}

}
