package org.mgt.gestionsprojets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@GetMapping("/")
	public String index() {
		return "task/index" ;
	}
	
	@GetMapping("/add")
	public String add() {
		return "/task/add" ;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id) {
		return "task/edit" ;
	}
	
	@GetMapping("/show")
	public String show() {
		return "task/show" ;
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "task/delete" ;
	}
}