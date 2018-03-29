package org.mgt.gestionsprojets.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id ;
	
	@Column(name="username",nullable=false)
	private String username ;
	
	@Column(name="password",nullable=false)
	private String password ;
	
	@Column(name="firstName",nullable=false)
	private String firstName ;
	
	
	@Column(name="lastName",nullable=false)
	private String lastName ;
	
	@JsonIgnore
	@OneToMany(mappedBy="assignedUser")
	private List<Task> tasks ;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="user_role",
		joinColumns= {@JoinColumn(name="user_id")},
		inverseJoinColumns= {@JoinColumn(name="role_id")}
	)
	private List<Role> roles ;
	
	
}
