package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.response.TicketsCategoryResponseDTO;

public interface TicketsCategoryService {

	public TicketsCategoryResponseDTO getById(int id) throws Exception;
	public TicketsCategoryResponseDTO getByCode(String code) throws Exception;
	
}
