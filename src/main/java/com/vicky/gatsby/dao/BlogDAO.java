package com.vicky.gatsby.dao;

import java.util.List;

import com.vicky.gatsby.model.Blogdetails;

public interface BlogDAO {

	public boolean save(Blogdetails blog);
	
	public Blogdetails delete(String blogname);
	
	public boolean update (Blogdetails blog);
	
	public List<Blogdetails> bloglist();
	
	public Blogdetails getbyid(String blogid);
}
