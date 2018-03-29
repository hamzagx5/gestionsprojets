package org.mgt.gestionsprojets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/test")
	//@ResponseBody
	public String index() {
		return "temp" ;
	}
	
	@GetMapping("/message")
	public String getMessage() {
		return "temp" ;
	}
	
}
