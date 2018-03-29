package org.mgt.gestionsprojets.resource;

import java.util.List;

import org.mgt.gestionsprojets.domain.Task;
import org.mgt.gestionsprojets.domain.User;
import org.mgt.gestionsprojets.service.TaskService;
import org.mgt.gestionsprojets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired //DI
	private UserService userService ;
	
	@Autowired
	private TaskService taskService ;
	//program to an interface not to implementation
	// single responsibility  
    //IOC

	@GetMapping(value="/")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(value="/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return userService.findOne(userId);
	}
	
	@GetMapping(value="/{userId}/tasks/")
	public List<Task> getTasks(@PathVariable Integer userId) {
		List<Task> tasks = taskService.findByAssignedUserId(userId);
		return tasks;
	}
	
	@PostMapping(value="/")
	public void saveUser(@RequestBody User user) {
		userService.save(user);
	}
	
	@PutMapping(value="/")
	public void updateUser(@RequestBody User user) {
		userService.update(user);
	}
	
	@DeleteMapping(value="/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.delete(userId);
	}
	
	
}
