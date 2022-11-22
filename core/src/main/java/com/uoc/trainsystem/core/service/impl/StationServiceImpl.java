package com.uoc.trainsystem.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.response.StationResponseDTO;
import com.uoc.trainsystem.core.service.StationService;
import com.uoc.trainsystem.repository.StationRepository;
import com.uoc.trainsystem.repository.entities.Station;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepository stationRepository;
	
	@MethodLogging
	@Override
	public StationResponseDTO getById(int id) throws Exception {
		Station station = null;
		Optional<Station> optStation = this.stationRepository.findById(id);
		if(optStation.isPresent()) {
			station = optStation.get();
		}
		return buildResponse(station);
	}
	
	private StationResponseDTO buildResponse(Station res) {
		return StationResponseDTO.builder()
			.id(res != null ? res.getId () : null)
			.name(res != null ? res.getName() : null)
			.build();
	}

}
