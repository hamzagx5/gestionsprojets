package org.mgt.gestionsprojets.service;

import java.util.List;

import org.mgt.gestionsprojets.domain.Task;

public interface TaskService {
	public List<Task> findAll();
	public Task findOne(Integer taskId);
	public void save(Task project);
	public void update(Task project);
	public void delete(Integer taskId);
	public List<Task> findByAssignedUserId(Integer userId);
}
