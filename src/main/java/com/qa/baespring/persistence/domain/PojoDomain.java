package com.qa.baespring.persistence.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PojoDomain {
	
	@Id // This sets the variable to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this Auto-Increments for us
	@Column(name = "pojo_id") // assign a custom name to the column
	private Long id;
	
	private String name;
	
	// constructors
	
	// default constructor
	public PojoDomain() {
		super();
	}
	
	// all arguments constructor
	public PojoDomain(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// getters and setters
	
	// get pojo_id
	public long getId() {
		return id;
	}
	
	// get name
	public String getName() {
		return name;
	}
	
	// set pojo_id
	public void setId(Long id) {
		this.id = id;
	}
	
	// set pojo_id
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * N.B: You shouldn't need getters and setters for the id because it
	 * is generated and incremented automatically by the Spring Data JPA
	 */
}
