package org.mgt.gestionsprojets.dao;

import org.mgt.gestionsprojets.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
