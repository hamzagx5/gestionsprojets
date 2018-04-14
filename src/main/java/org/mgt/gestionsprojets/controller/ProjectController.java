package org.mgt.gestionsprojets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@GetMapping("/")
	public String index() {
		return "project/index" ;
	}
	
	@GetMapping("/show")
	public String show() {
		return "task/show" ;
	}
	
	@GetMapping("/add")
	public String add() {
		return "/project/add" ;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id) {
		return "project/edit" ;
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "project/delete" ;
	}
}