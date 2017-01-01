package com.vicky.gatsby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class Maincontroller {

	@RequestMapping("/")
	public String maincontrol()
	{
		
		return "index";
	}
}
