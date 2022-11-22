package com.uoc.trainsystem.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDTO {

	private Long userId;
	private String firstName;
	private String secondName;
	private String userName;
	private String email;
	
}
