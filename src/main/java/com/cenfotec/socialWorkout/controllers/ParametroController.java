package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.ParametroRequest;
import com.cenfotec.socialWorkout.contracts.ParametroResponse;
import com.cenfotec.socialWorkout.services.ParametroService;

@RestController
@RequestMapping(value ="rest/protected/parametro")
public class ParametroController {
	
	@Autowired private ParametroService parametroService;
	@Autowired private HttpServletRequest request;

	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public ParametroResponse getAll(@RequestBody ParametroRequest pr){	
			
		ParametroResponse us = new ParametroResponse();
		us.setCode(200);
		us.setCodeMessage("Parametro fetch success");
		us.setParametros(parametroService.getAll(pr));
		return us;		
	}
		
	@RequestMapping(value ="/getAllByName", method = RequestMethod.POST)
	public ParametroResponse getAllByName(@RequestBody ParametroRequest pr){	
			
		ParametroResponse ps = new ParametroResponse();
		ps.setCode(200);
		ps.setCodeMessage("parametro fetch success");
		ps.setParametros(parametroService.getAllByName(pr));
		return ps;		
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public ParametroResponse create(@RequestBody ParametroRequest pr){	
		ParametroResponse ps = new ParametroResponse();
		Boolean state = parametroService.saveParametro(pr);
	
		if(state){
			ps.setCode(200);
			ps.setCodeMessage("parametro created succesfully");
		}
		return ps;
		
	}
}
