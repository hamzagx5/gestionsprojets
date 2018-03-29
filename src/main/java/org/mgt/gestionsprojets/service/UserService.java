package org.mgt.gestionsprojets.service;

import java.util.List;

import org.mgt.gestionsprojets.domain.User;

public interface UserService {
	
	public List<User> findAll();
	public User findOne(Integer userId);
	public void save(User user);
	public void update(User user);
	public void delete(Integer userId);
	
}

