package org.mgt.gestionsprojets.resource;

import java.util.List;

import org.mgt.gestionsprojets.domain.Task;
import org.mgt.gestionsprojets.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskResource {
	
	// private static Logger LOG = LoggerFactory.getLogger(TaskResource.class);
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Task> getAllTasks(){
		return taskService.findAll();
	}
	
	@RequestMapping(value="/{taskId}",method=RequestMethod.GET)
	public Task getTaskById(@PathVariable Integer taskId) {
		return taskService.findOne(taskId);
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void saveTask(@RequestBody Task task) {
		 taskService.save(task);
	}
	
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void updateTask(@RequestBody Task task) {
		 taskService.save(task);
	}
	
	@RequestMapping(value="/{taskId}",method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable Integer taskId) {
		 taskService.delete(taskId);	
	}
	

}
