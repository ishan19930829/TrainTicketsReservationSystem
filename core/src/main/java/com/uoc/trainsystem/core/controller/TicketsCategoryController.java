package com.uoc.trainsystem.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.TicketsCategoryResponseDTO;
import com.uoc.trainsystem.core.service.TicketsCategoryService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/mst-tickets-category")
public class TicketsCategoryController {
	
	@Autowired
	private TicketsCategoryService mstTicketsCategoryService;
	
	@GetMapping("/{id}")
	public AppResponse<TicketsCategoryResponseDTO> getMstTicketsCategoryById(
			@ApiParam(required = true , name = "id") @PathVariable int id) {
		try {
			TicketsCategoryResponseDTO response = this.mstTicketsCategoryService.getById(id);
			return AppResponse.ok(response);
			
		} catch (Exception e) {	
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "not existing value");
		
		}	
	}
	
	@GetMapping("/code/{code}")
	public AppResponse<TicketsCategoryResponseDTO> getMstTicketsCategoryByCode(
			@ApiParam(required = true , name = "code") @PathVariable String code) {
		try {
			TicketsCategoryResponseDTO response = this.mstTicketsCategoryService.getByCode(code);
			return AppResponse.ok(response);
			
		} catch (Exception e) {	
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "not existing value");
		
		}	
	}
	

}
