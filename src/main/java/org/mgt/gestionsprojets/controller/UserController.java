package org.mgt.gestionsprojets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/")
	public String index() {
		return "user/index" ;
	}
	
	@GetMapping("/show")
	public String show() {
		return "task/show" ;
	}
	
	@GetMapping("/add")
	public String add() {
		return "/user/add" ;
	}
	
	@GetMapping("/edit")
	public String edit() {
		return "user/edit" ;
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "user/delete" ;
	}
}