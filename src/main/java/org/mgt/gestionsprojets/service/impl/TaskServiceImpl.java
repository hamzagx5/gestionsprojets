package org.mgt.gestionsprojets.service.impl;

import java.util.List;

import org.mgt.gestionsprojets.dao.TaskDao;
import org.mgt.gestionsprojets.domain.Task;
import org.mgt.gestionsprojets.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDao  taskDao ;
	
	@Override
	public List<Task> findAll() {
		return taskDao.findAll();
	}

	@Override
	public Task findOne(Integer taskId) {
		return taskDao.findOne(taskId);
	}

	@Override
	public void save(Task task) {
		taskDao.save(task);
	}

	@Override
	public void update(Task task) {
		taskDao.save(task);
	}

	@Override
	public void delete(Integer taskId) {
		taskDao.delete(taskId);
	}

	@Override
	public List<Task> findByAssignedUserId(Integer userId) {
		return taskDao.findByAssignedUserId(userId);
	}

}
