package com.qa.baespring.persistence.dto;

public class PojoDTO {
	
	// variables
	
	private Long id;
	private String name;
	
	// constructors
	
	public PojoDTO() {
		super();
	}
	
	public PojoDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	// getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
