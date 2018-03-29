package org.mgt.gestionsprojets.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id ;
	
	@Column(name="name",nullable=false)
	private String name ;
	
	@Column(name="description",nullable=true)
	private String description ;
	
	@JsonIgnore
	@ManyToMany(mappedBy="roles")
	private List<User> users ;
	
}