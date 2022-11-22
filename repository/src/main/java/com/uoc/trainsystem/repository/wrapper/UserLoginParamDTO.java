package com.uoc.trainsystem.repository.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginParamDTO {

	private String userName;
	private String password;
	
}
