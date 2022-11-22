package com.uoc.trainsystem.repository.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.dao.DisplayTicketPriceDAO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceMappingDTO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceParamDTO;

@Repository
public class DisplayTicketPriceDAOImpl implements DisplayTicketPriceDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public DisplayTicketPriceMappingDTO displayPrice(DisplayTicketPriceParamDTO param) {
		StringBuilder nativeQuery = new StringBuilder();
			nativeQuery.append("SELECT ");
			nativeQuery.append("tp.id,");
			nativeQuery.append("tp.price ");
			nativeQuery.append("FROM ticket_price AS tp ");
			nativeQuery.append("INNER JOIN mst_station AS sms ON tp.start_station_id = sms.id ");
			nativeQuery.append("INNER JOIN mst_station AS ems ON tp.end_station_id = ems.id ");
			nativeQuery.append("INNER JOIN mst_tickets_category AS mtc ON tp.mst_tickets_category_id = mtc.id ");
			nativeQuery.append("WHERE ");
			nativeQuery.append("tp.start_station_id = ");
			nativeQuery.append(param.getStartStationId());
			nativeQuery.append(" AND ");
			nativeQuery.append("tp.end_station_id = ");
			nativeQuery.append(param.getEndStationId());
			nativeQuery.append(" AND ");
			nativeQuery.append("tp.mst_tickets_category_id = ");
			nativeQuery.append(param.getTicketCategoryId());
			
		Query query = this.entityManager.createNativeQuery(nativeQuery.toString(), "DisplayTicketPrice");	
		return (DisplayTicketPriceMappingDTO) query.getSingleResult();
	}

	@Override
	public DisplayTicketPriceMappingDTO displayPriceReverse(DisplayTicketPriceParamDTO param) {
		StringBuilder nativeQuery = new StringBuilder();
		nativeQuery.append("SELECT ");
		nativeQuery.append("tp.id,");
		nativeQuery.append("tp.price ");
		nativeQuery.append("FROM ticket_price AS tp ");
		nativeQuery.append("INNER JOIN mst_station AS sms ON tp.start_station_id = sms.id ");
		nativeQuery.append("INNER JOIN mst_station AS ems ON tp.end_station_id = ems.id ");
		nativeQuery.append("INNER JOIN mst_tickets_category AS mtc ON tp.mst_tickets_category_id = mtc.id ");
		nativeQuery.append("WHERE ");
		nativeQuery.append("tp.start_station_id = ");
		nativeQuery.append(param.getEndStationId());
		nativeQuery.append(" AND ");
		nativeQuery.append("tp.end_station_id = ");
		nativeQuery.append(param.getStartStationId());
		nativeQuery.append(" AND ");
		nativeQuery.append("tp.mst_tickets_category_id = ");
		nativeQuery.append(param.getTicketCategoryId());
		
	Query query = this.entityManager.createNativeQuery(nativeQuery.toString(), "DisplayTicketPrice");	
	return (DisplayTicketPriceMappingDTO) query.getSingleResult();
	}

}
