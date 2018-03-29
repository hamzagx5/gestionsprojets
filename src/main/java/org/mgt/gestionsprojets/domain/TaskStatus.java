package org.mgt.gestionsprojets.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@DiscriminatorValue(value="task")
public class TaskStatus extends Status{

	@JsonIgnore
	@OneToMany(mappedBy="status")
	private List<Task> tasks ;
	
}
