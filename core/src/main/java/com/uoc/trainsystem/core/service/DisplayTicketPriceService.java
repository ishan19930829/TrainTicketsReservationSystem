package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.request.DisplayTicketPriceRequest;
import com.uoc.trainsystem.core.response.DisplayTicketPriceResponseDTO;

public interface DisplayTicketPriceService {

	public DisplayTicketPriceResponseDTO getTicketPrice(DisplayTicketPriceRequest req) throws Exception;
	
}
