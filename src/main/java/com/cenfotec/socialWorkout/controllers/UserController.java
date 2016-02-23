package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.contracts.UserResponse;
import com.cenfotec.socialWorkout.services.UserServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/users")
public class UserController {
	
	@Autowired private UserServiceInterface usersService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public UserResponse getAll(@RequestBody UserRequest ur){	
			
		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAll(ur));
		return us;		
	}
	
	@RequestMapping(value ="/getAllByName", method = RequestMethod.POST)
	public UserResponse getAllByName(@RequestBody UserRequest ur){	
			
		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAllByName(ur));
		return us;		
	}
	
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UserResponse create(@RequestBody UserRequest ur){	
		
		UserResponse us = new UserResponse();
		Boolean state = usersService.saveUser(ur);
	
		if(state){
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}
		return us;
		
	}

}
