package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.request.UserLoginRequest;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;

public interface UserLoginService {

	public UserLoginResponseDTO login(UserLoginRequest req) throws Exception;
	
}
