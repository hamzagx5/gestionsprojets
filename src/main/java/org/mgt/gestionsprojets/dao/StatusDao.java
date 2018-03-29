package org.mgt.gestionsprojets.dao;

import org.mgt.gestionsprojets.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer>{
	
}
