package com.uoc.trainsystem.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.request.AppRequest;
import com.uoc.trainsystem.core.request.UserLoginRequest;
import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;
import com.uoc.trainsystem.core.service.UserLoginService;

@RestController
@RequestMapping("/user-login")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping
	public AppResponse<UserLoginResponseDTO> userLogin(@RequestBody AppRequest<UserLoginRequest> req) {
		try {
			UserLoginResponseDTO response = this.userLoginService.login(req.getData());
			return AppResponse.ok(response);
			
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "userName or password invalid");
		}
	}
	
}
