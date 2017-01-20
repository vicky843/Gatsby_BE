package com.vicky.gatsby.controller;

import java.util.List;
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
	@RequestMapping(value="/updatingblog", method=RequestMethod.PUT)
public ResponseEntity<Blogdetails> update(@RequestBody Blogdetails blogs){
		System.out.println("update blog1");
		blog.update(blogs);
		System.out.println("update blog2");
		return new ResponseEntity<Blogdetails>(blogs,HttpStatus.OK);
	}
@RequestMapping(value="/deleteblog/{blogname}",method=RequestMethod.GET)
public ResponseEntity<Blogdetails> delete(@PathVariable("blogname") String blogname)
{
	System.out.println("delte blog");
	/*Blogdetails bg=blog.setBlogname(blogname);*/
	
	Blogdetails bg=blog.delete(blogname);
	bg.setErrorcode("200");
	bg.setErrormsg("successfully deleted");
	System.out.println("delte blog2");

	return new ResponseEntity<Blogdetails>(bg,HttpStatus.OK);	
}
@RequestMapping(value="/blogbyid/{blogname}",method=RequestMethod.GET)
public ResponseEntity<Blogdetails> blogsingleid(@PathVariable("blogname") String blogname)
{
	Blogdetails bd=blog.getbyid(blogname);
return new ResponseEntity<Blogdetails>(bd,HttpStatus.OK);	
}

@RequestMapping(value="/bloglist",method=RequestMethod.GET)
public ResponseEntity <List<Blogdetails>> listblog()
{
System.out.println("listblogcntrl");
List<Blogdetails> list=blog.bloglist();
return new ResponseEntity <List<Blogdetails>>(list,HttpStatus.OK);
}
}
