package com.vicky.gatsby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

@RestController
public class Admincontroller {

	@Autowired
	PersonDAO p;

	@RequestMapping(value="/changerole/{username}/{role}",method=RequestMethod.GET)
public ResponseEntity<Persondetails>(@PathVariable("username")String username,)
	{
		
		return new ResponseEntity<Persondetails>(body, headers, status);
	}
}
