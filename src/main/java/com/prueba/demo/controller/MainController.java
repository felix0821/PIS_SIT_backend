package com.prueba.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping({"/"})
	public String index() {
		System.out.println("se llego --");
		return "index";
	}
	
	
	
}
