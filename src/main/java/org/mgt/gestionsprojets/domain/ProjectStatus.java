package org.mgt.gestionsprojets.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@DiscriminatorValue(value="project")
public class ProjectStatus extends Status{

	@JsonIgnore
	@OneToMany(mappedBy="status")
	private List<Project> projects;
}
