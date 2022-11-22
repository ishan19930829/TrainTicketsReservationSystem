package com.uoc.trainsystem.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.request.DisplayTicketPriceRequest;
import com.uoc.trainsystem.core.response.DisplayTicketPriceResponseDTO;
import com.uoc.trainsystem.core.service.DisplayTicketPriceService;
import com.uoc.trainsystem.repository.dao.DisplayTicketPriceDAO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceMappingDTO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceParamDTO;

@Service
public class DisplayTicketPriceServiceImpl implements DisplayTicketPriceService {

	@Autowired
	private DisplayTicketPriceDAO displayTicketPriceDAO;
	
	@MethodLogging
	@Override
	public DisplayTicketPriceResponseDTO getTicketPrice(DisplayTicketPriceRequest req) throws Exception {
		
		if(req.getEndStationId() >= req.getStartStationId()) {
			
			if(!(req.getStartStationId().equals(req.getEndStationId()))) {
				DisplayTicketPriceMappingDTO response = this.displayTicketPriceDAO.displayPrice(buidRequest(req));
				return buidResponse(response);
			} else {
				return DisplayTicketPriceResponseDTO.builder().price(0.00).build();
			}
			
		} else {
			DisplayTicketPriceMappingDTO resReverse = this.displayTicketPriceDAO.displayPriceReverse(buidRequest(req));
			return buidResponse(resReverse);
		}
		
		
		
	}
	
	private DisplayTicketPriceResponseDTO buidResponse(DisplayTicketPriceMappingDTO res) {
		return DisplayTicketPriceResponseDTO.builder()
				.price(res.getPrice())
				.build();
	}
	
	private DisplayTicketPriceParamDTO buidRequest(DisplayTicketPriceRequest req) {
		return DisplayTicketPriceParamDTO.builder()
				.startStationId(req.getStartStationId())
				.endStationId(req.getEndStationId())
				.ticketCategoryId(req.getTicketCategoryId())
				.build();
	}

}
