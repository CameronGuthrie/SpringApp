package com.qa.baespring.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.baespring.persistence.domain.PojoDomain;

@Repository
public interface PojoRepo extends JpaRepository<PojoDomain, Long>  {

}
