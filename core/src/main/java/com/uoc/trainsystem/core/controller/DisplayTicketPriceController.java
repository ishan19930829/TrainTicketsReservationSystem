package com.uoc.trainsystem.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.request.AppRequest;
import com.uoc.trainsystem.core.request.DisplayTicketPriceRequest;
import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.DisplayTicketPriceResponseDTO;
import com.uoc.trainsystem.core.service.DisplayTicketPriceService;

@RestController
@RequestMapping("/display-ticket-price")
public class DisplayTicketPriceController {

	@Autowired
	private DisplayTicketPriceService displayTicketPriceService;
	
	@PostMapping
	public AppResponse<DisplayTicketPriceResponseDTO> displayTicketPrice(@RequestBody AppRequest<DisplayTicketPriceRequest> req){
		try {
			DisplayTicketPriceResponseDTO response = this.displayTicketPriceService.getTicketPrice(req.getData());
			return AppResponse.ok(response);
			
		} catch (Exception e) {	
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "get price is invalid");
		
		}	
	}
	
}
