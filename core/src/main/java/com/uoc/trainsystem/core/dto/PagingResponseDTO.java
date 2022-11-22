package com.uoc.trainsystem.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PagingResponseDTO {
	private int pageNumber;
	private int pageSize;
	private long totalRecords;
}
