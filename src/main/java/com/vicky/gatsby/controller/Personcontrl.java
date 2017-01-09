package com.vicky.gatsby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

@RestController
public class Personcontrl {
@Autowired
PersonDAO per;
	/*private static final Logger logger = LoggerFactory.getLogger(Personcontrl.class);
	*/
@RequestMapping(value="/person",method=RequestMethod.POST,headers="Accept=application/json")
 
	public ResponseEntity<Persondetails> savingperson(@RequestBody Persondetails person )
	{
		
	per.save(person);
	System.out.println("personcontroller");	
	return new ResponseEntity<Persondetails>(person,HttpStatus.OK);
	}

@RequestMapping(value="/personupdate	",method=RequestMethod.PUT,headers="Accept=application/json")

public ResponseEntity<Persondetails> updatingperson(@RequestBody Persondetails person )
{
	
per.update(person);
System.out.println("personcontroller");	
return new ResponseEntity<Persondetails>(person,HttpStatus.OK);
}

}
