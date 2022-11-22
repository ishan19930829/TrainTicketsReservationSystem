package com.uoc.trainsystem.core.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("password")
	private String password;
	
}
