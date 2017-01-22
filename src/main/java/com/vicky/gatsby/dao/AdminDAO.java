package com.vicky.gatsby.dao;

import com.vicky.gatsby.model.Persondetails;

public interface AdminDAO {

	public Persondetails personroleupdate(String username,String role);
	
	public Persondetails personstatusupdate(String username,String status);
}
