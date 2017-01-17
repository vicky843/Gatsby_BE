package com.vicky.gatsby.dao;

import java.util.List;

import com.vicky.gatsby.model.Persondetails;

public interface PersonDAO {

	
	public boolean save(Persondetails person);
	
	public boolean update(Persondetails person);
	/*
	public boolean delete(String id);*/
	
	public List<Persondetails> getperlist();
	
	public Persondetails getid(String id);
	/*
	public Persondetails login(String username,String password);
	//it can be removed if spring security is applied
*/
public Persondetails login(Persondetails person);

}
