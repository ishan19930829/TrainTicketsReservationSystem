package com.uoc.trainsystem.core.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisplayTicketPriceRequest {

	private Integer startStationId;
	private Integer endStationId;
	private Integer ticketCategoryId;
	
}
