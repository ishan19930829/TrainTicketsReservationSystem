package com.uoc.trainsystem.repository.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "DisplayTicketPrice" , entities = {
		@EntityResult(entityClass = DisplayTicketPriceMappingDTO.class , fields = {
			@FieldResult(name = "id" , column = "id"),
			@FieldResult(name = "price" , column = "price"),
		}),
})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DisplayTicketPriceMappingDTO {

	@Id
	private Integer id;
	private Double price;
	
}
