package com.vicky.gatsby.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vicky.gatsby.configuration.Dispatcherconfig;
import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

@Controller
public class Personcontrl {
@Autowired
PersonDAO per;
	/*private static final Logger logger = LoggerFactory.getLogger(Personcontrl.class);*/
	
	@RequestMapping(value="/person",method=RequestMethod.POST)
	 
	public ResponseEntity<String> person(@RequestBody Persondetails person)
	{
		
		per.save(person);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
