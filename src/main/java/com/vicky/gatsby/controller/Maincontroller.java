package com.vicky.gatsby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.gatsby.dao.PersonDAO;
import com.vicky.gatsby.model.Persondetails;
@RestController

public class Maincontroller {

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String maincontrol()
	{
		System.out.println("working part");
		

		return "index";
	}
}
