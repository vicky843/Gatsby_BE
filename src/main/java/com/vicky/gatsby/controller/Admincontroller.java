package com.vicky.gatsby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.gatsby.dao.AdminDAO;
import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

@RestController
public class Admincontroller {

	@Autowired
	AdminDAO ad;

	@RequestMapping(value="/changerole/{username}/{role}",method=RequestMethod.GET)
public ResponseEntity<Persondetails> roleupdate(@PathVariable("username")String username,@PathVariable("role")String role)
	{
		Persondetails per=ad.personroleupdate(username, role);
		System.out.println("Admin roleupdate controller");
		return new ResponseEntity<Persondetails>(per,HttpStatus.OK);
	}
	@RequestMapping(value="/changestatus/{username}/{status}",method=RequestMethod.GET)
	public ResponseEntity<Persondetails> statusupdate(@PathVariable("username")String username,@PathVariable("status")String status)
	{

		Persondetails per=ad.personstatusupdate(username, status);
		System.out.println("Admin statusupdate controller");
		return new ResponseEntity<Persondetails>(per,HttpStatus.OK);
		
	}
}
