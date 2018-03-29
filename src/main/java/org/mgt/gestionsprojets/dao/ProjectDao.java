package org.mgt.gestionsprojets.dao;

import org.mgt.gestionsprojets.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{

}
