package org.mgt.gestionsprojets.service.impl;

import java.util.List;

import org.mgt.gestionsprojets.dao.UserDao;
import org.mgt.gestionsprojets.domain.User;
import org.mgt.gestionsprojets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*sonisoniheho 
@component
@service @controller @repository 
*/

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao ;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findOne(Integer userId) {
		return userDao.findOne(userId);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(Integer userId) {
		userDao.delete(userId);
	}

}
