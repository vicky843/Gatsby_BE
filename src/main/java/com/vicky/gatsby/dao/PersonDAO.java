package com.vicky.gatsby.dao;

import com.vicky.gatsby.model.Persondetails;

public interface PersonDAO {

	
	public boolean save(Persondetails person);
	
	public boolean update(Persondetails person);
	
	
}
