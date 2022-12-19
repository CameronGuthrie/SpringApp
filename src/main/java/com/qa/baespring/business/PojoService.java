package com.qa.baespring.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.baespring.persistence.domain.PojoDomain;
import com.qa.baespring.persistence.dto.PojoDTO;
import com.qa.baespring.persistence.repo.PojoRepo;

@Service
public class PojoService {
	
	// dependencies
	private PojoRepo repo; // our JPA repo for our Pojo
	private ModelMapper mapper; // automatically maps DTOs onto Entities (need to create the Bean in config)
	
	// constructor
	@Autowired // saves us writing boilerplate to connect them
	public PojoService(PojoRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private PojoDTO mapToDto(PojoDomain model) {
		return this.mapper.map(model, PojoDTO.class);
	}
	
	/*
	 * C R U D
	 */
	
	// Create - POST
	public PojoDTO create(PojoDomain model) {
		return this.mapToDto(this.repo.save(model));
	}
	
	// Read - GET
	//	all (using a stream)
	public List<PojoDTO> readAll() {
		return this.repo.findAll().stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	//	one
	public PojoDTO readOne(Long id) {
		return this.mapToDto(this.repo.findById(id).orElseThrow());
	}
	
	// Update - PUT/PATCH
	public PojoDTO update(long id, PojoDomain model) {
		Optional<PojoDomain> opt = this.repo.findById(id);
		PojoDomain existing = opt.orElseThrow();

		existing.setName(model.getName());

		return this.mapToDto(this.repo.save(existing));
	}
	
	// Delete - DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
}
