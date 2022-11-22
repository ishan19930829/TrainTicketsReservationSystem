package com.uoc.trainsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.entities.TicketsCategory;

@Repository
public interface TicketsCategoryRepository extends JpaRepository<TicketsCategory, Integer> {

	Optional<TicketsCategory> findByCode(String code);
	
}
