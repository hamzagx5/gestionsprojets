package org.mgt.gestionsprojets.dao;

import java.util.List;

import org.mgt.gestionsprojets.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
	List<Task> findById(Integer id);
	List<Task> findByName(String name);
	//jpql hql  @Query
	//@Query("select u from User u where u.id=?")
	//@Query(nativeQuery="select * from users where user_id=?")
	List<Task> findByAssignedUserId(Integer id);

}
