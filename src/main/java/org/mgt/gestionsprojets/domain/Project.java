package org.mgt.gestionsprojets.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data //generate getter and setter (lombok dependancy)
@Table(name="projects")
public class Project{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="status_id",
	foreignKey=@ForeignKey(name="FK_Project_status_StatusProject"))
	@ManyToOne
	private Status status;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="user_id",
	foreignKey=@ForeignKey(name="FK_Project_User_id_User"))
	@ManyToOne
	private User owner ;
	
	@JsonIgnore
	@OneToMany(mappedBy="project")
	private List<Task> tasks ;
	
	
}
