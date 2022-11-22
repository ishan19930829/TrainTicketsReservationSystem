package com.uoc.trainsystem.core.request;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRequest<T> {
	@Valid
	private T data;
}
