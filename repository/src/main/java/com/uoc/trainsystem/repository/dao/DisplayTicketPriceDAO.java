package com.uoc.trainsystem.repository.dao;

import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceMappingDTO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceParamDTO;

public interface DisplayTicketPriceDAO {

	public DisplayTicketPriceMappingDTO displayPrice(DisplayTicketPriceParamDTO param);
	public DisplayTicketPriceMappingDTO displayPriceReverse(DisplayTicketPriceParamDTO param);
	
}
