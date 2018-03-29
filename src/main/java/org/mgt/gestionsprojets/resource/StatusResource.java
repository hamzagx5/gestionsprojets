package org.mgt.gestionsprojets.resource;

import java.util.List;

import org.mgt.gestionsprojets.dao.StatusDao;
import org.mgt.gestionsprojets.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statuses")
public class StatusResource {
	
	@Autowired //DI
	private StatusDao statusService ;
	
	
	//program to an interface not to implementation
	// single responsibility  
    //IOC

	@GetMapping(value="/")
	public List<Status> getAllStatuses() {
		return statusService.findAll();
	}
	
	@GetMapping(value="/{statusId}")
	public Status getStatus(@PathVariable Integer statusId) {
		return statusService.findOne(statusId);
	}
	
	

	
	
}
