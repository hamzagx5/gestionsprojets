package org.mgt.gestionsprojets.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;
	
	//@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="assignedUser_id",foreignKey=@ForeignKey(name="FK_TASK_assignedUser_USERS"))
	@ManyToOne
	private User assignedUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dueDate", nullable = false)
	private Date dueDate;

	//@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="project_id",foreignKey=@ForeignKey(name="FK_TASK_project_PROJECT"))
	@ManyToOne
	private Project project;

	//@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="status_id",foreignKey=@ForeignKey(name="FK_TASK_status_STATUS"))
	@ManyToOne
	private Status status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate", nullable = true)
	private Date endDate;

}
