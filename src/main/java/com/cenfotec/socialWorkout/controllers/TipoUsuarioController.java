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


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/tipousers")
public class TipoUsuarioController {
	
	@Autowired private TipoUsuarioServiceInterface tipoUsuarioService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public TipoUsuarioResponse getAll(@RequestBody TipoUsuarioRequest ur){	
			
		TipoUsuarioResponse tus = new TipoUsuarioResponse();
		tus.setCode(200);
		tus.setCodeMessage("tipousers fetch success");
		tus.setTipoUsuariosList(tipoUsuarioService.getAll());
		return tus;		
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public TipoUsuarioResponse create(@RequestBody TipoUsuarioRequest ur){	
		
		TipoUsuarioResponse tus = new TipoUsuarioResponse();
		Boolean state = tipoUsuarioService.saveTipoUsuario(ur);
	
		if(state){
			tus.setCode(200);
			tus.setCodeMessage("user created succesfully");
		}
		return tus;
		
	}
}
