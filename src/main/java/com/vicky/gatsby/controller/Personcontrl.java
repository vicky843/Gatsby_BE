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

import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;

@RestController
public class Personcontrl {
	@Autowired
	PersonDAO per;

	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(Personcontrl.class);
	 */
	@RequestMapping(value = "/person", method = RequestMethod.POST, headers = "Accept=application/json")

	public ResponseEntity<Persondetails> savingperson(@RequestBody Persondetails preg) {
		String randomid = UUID.randomUUID().toString();
		System.out.println("savecontrollerbe");
		preg.setId(randomid);
		preg.setErrorcode("200");
		preg.setErrormsg("succesfully registered");
		preg.setStatus("pending");
		per.save(preg);
		System.out.println("personcontrol");
		return new ResponseEntity<Persondetails>(preg, HttpStatus.OK);
	}

	@RequestMapping(value = "/personupdate", method = RequestMethod.PUT, headers = "Accept=application/json")

	public ResponseEntity<Persondetails> updatingperson(@RequestBody Persondetails person) {

		per.update(person);
		System.out.println("personcontroller");
		return new ResponseEntity<Persondetails>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "/personlist", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Persondetails>> getlist() {
		System.out.println("listcontroller");
		List<Persondetails> plist = per.getperlist();
		return new ResponseEntity<List<Persondetails>>(plist, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginauth", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Persondetails> authentication(@RequestBody Persondetails person) {
	/*	person = per.login(person.getUsername(), person.getPassword());*/
		Persondetails perso=per.login(person);
		if (perso == null) {
			
			perso = new Persondetails();// to avoid NLP
			perso.setErrorcode("404");
			perso.setErrormsg("invalid user");
			return new ResponseEntity<Persondetails>(perso, HttpStatus.OK);
		} else {
			perso.setErrorcode("200");
			perso.setErrormsg("login succesful");
		}
		return new ResponseEntity<Persondetails>(perso, HttpStatus.OK);
	}
}
