package com.uoc.trainsystem.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponseDTO {
	private String status;
	private String source;
	private String title;
	private String detail;
}
