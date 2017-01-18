package com.vicky.gatsby.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.gatsby.dao.BlogDAO;
import com.vicky.gatsby.model.Blogdetails;

@RestController
public class Blogcontrl {

	@Autowired
	BlogDAO blog;
	
	@RequestMapping(value="/saveblog",method=RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<Blogdetails> saveblog(@RequestBody Blogdetails blogs)
	{
		String randomid = UUID.randomUUID().toString();
		blogs.setBlogid(randomid);
		blogs.setErrorcode("200");
		blogs.setErrormsg("succesfullysaved blog");
		blog.save(blogs);
		System.out.println("Saveblogbe controller");
		return new ResponseEntity<Blogdetails>(blogs,HttpStatus.OK);
	}
	@RequestMapping(value="/updateblog/{title}",method=RequestMethod.PUT,headers = "Accept=application/json")
public ResponseEntity<Blogdetails> update(@RequestBody Blogdetails blogs){
		
		blog.update(blogs);
		return new ResponseEntity<Blogdetails>(blogs,HttpStatus.OK);
	}

}
