package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.response.StationResponseDTO;

public interface StationService {

	public StationResponseDTO getById(int id) throws Exception;
	
}
