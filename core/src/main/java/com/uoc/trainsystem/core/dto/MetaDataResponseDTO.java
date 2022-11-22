package com.uoc.trainsystem.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MetaDataResponseDTO {
	private Integer code;
	private String message;
}
