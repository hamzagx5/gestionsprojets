package org.mgt.gestionsprojets.service;

import java.util.List;

import org.mgt.gestionsprojets.domain.Project;

public interface ProjectService {
	public List<Project> findAll();
	public Project findOne(Integer projectId);
	public void save(Project project);
	public void update(Project project);
	public void delete(Integer projectId);
}
