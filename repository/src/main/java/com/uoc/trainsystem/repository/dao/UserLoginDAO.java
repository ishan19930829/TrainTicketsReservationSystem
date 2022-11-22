package com.uoc.trainsystem.repository.dao;

import com.uoc.trainsystem.repository.wrapper.UserLoginMappingDTO;
import com.uoc.trainsystem.repository.wrapper.UserLoginParamDTO;

public interface UserLoginDAO {

	public UserLoginMappingDTO viewUserLogin(UserLoginParamDTO param);
	
}
