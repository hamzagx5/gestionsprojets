package org.mgt.gestionsprojets.service.impl;

import java.util.List;

import org.mgt.gestionsprojets.dao.ProjectDao;
import org.mgt.gestionsprojets.domain.Project;
import org.mgt.gestionsprojets.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao ;
	
	@Override
	public List<Project> findAll() {
		return projectDao.findAll();
	}

	@Override
	public Project findOne(Integer projectId) {
		return projectDao.findOne(projectId);
	}

	@Override
	public void save(Project project) {
		projectDao.save(project);
	}

	@Override
	public void update(Project project) {
		projectDao.save(project);
	}

	@Override
	public void delete(Integer projectId) {
		projectDao.delete(projectId);
	}

}
