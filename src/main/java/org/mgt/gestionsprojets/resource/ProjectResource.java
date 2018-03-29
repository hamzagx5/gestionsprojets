package org.mgt.gestionsprojets.resource;


import java.util.List;

import org.mgt.gestionsprojets.domain.Project;
import org.mgt.gestionsprojets.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectResource {
	
	@Autowired
	private ProjectService projectService ;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Project> getAllProjects() {
		return projectService.findAll();
	}
	
	@RequestMapping(value="/{projectId}",method=RequestMethod.GET)
	public Project getProject(@PathVariable Integer projectId) {
		return projectService.findOne(projectId);
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void saveProject(@RequestBody Project project) {
		projectService.save(project);
	}
	
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void updateProject(@RequestBody Project project) {
		projectService.save(project);
	}
	
	@RequestMapping(value="/{projectId}",method=RequestMethod.DELETE)
	public void deleteProject(@PathVariable Integer projectId) {
		projectService.delete(projectId);
	}
}
