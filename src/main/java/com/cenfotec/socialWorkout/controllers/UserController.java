package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioResponse;
import com.cenfotec.socialWorkout.services.TipoUsuarioServiceInterface;
import com.cenfotec.socialWorkout.services.UserServiceInterface;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.contracts.UserResponse;


@RestController
@RequestMapping(value ="rest/protected/users")
public class UserController {
	
	
	//meter estos en uno solo service despues
	@Autowired 
	private UserServiceInterface usersService;
	@Autowired
	private TipoUsuarioServiceInterface tipoUserService;
	@Autowired 
	private HttpServletRequest request;
	
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
		boolean state = usersService.saveUser(ur);
	
		if(state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}
		return us;
		
	}
	@RequestMapping(value ="/getTiposUsuario", method = RequestMethod.POST)
	public TipoUsuarioResponse getTiposUsuario(@RequestBody UserRequest ur){	
		
		
		TipoUsuarioResponse tr = new TipoUsuarioResponse();
		tr.setCode(200);
		tr.setCodeMessage("users fetch success");
		tr.setTipoUsuariosList(tipoUserService.getAll());
		return tr;		
	}
	
	@RequestMapping(value ="/createTipo", method = RequestMethod.POST)
	public TipoUsuarioResponse createTipo(@RequestBody TipoUsuarioRequest ur){	
			
		TipoUsuarioResponse ut = new TipoUsuarioResponse();
		if(tipoUserService.saveTipoUsuario(ur)) {
			ut.setCode(200);
			ut.setCodeMessage("user type created succesfully");
			ut.setTipoUsuariosList(tipoUserService.getAll());
		}
		return ut;		
	}
	
	@RequestMapping(value ="/deleteTipo", method = RequestMethod.POST)
	public TipoUsuarioResponse deleteTipo(@RequestBody TipoUsuarioRequest ur){	
			
		TipoUsuarioResponse ut = new TipoUsuarioResponse();
		if(tipoUserService.deleteTipoUsuario(ur)) {
			ut.setCode(200);
			ut.setCodeMessage("user type created succesfully");
		}
		return ut;		
	}
	
	
}
