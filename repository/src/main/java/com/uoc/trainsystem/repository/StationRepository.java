package com.uoc.trainsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.entities.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
}
