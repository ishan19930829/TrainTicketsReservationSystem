package com.uoc.trainsystem.repository.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisplayTicketPriceParamDTO {

	private Integer startStationId;
	private Integer endStationId;
	private Integer ticketCategoryId;
	
}
