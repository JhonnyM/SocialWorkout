package com.cenfotec.socialWorkout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.ParametroRequest;
import com.cenfotec.socialWorkout.contracts.ParametroResponse;
import com.cenfotec.socialWorkout.ejb.Parametro;
import com.cenfotec.socialWorkout.services.ParametroServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/parametro")
public class ParametroController {
	
	@Autowired private ParametroServiceInterface parametroService;

	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public ParametroResponse getAll(@RequestBody ParametroRequest pr){	
		ParametroResponse ps = new ParametroResponse();
		ps.setCode(200);
		ps.setCodeMessage("Parametro fetch success");
		ps.setParametros(parametroService.getAll(pr));
		return ps;		
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
	public ParametroResponse create(@RequestBody Parametro pparametro){	
		ParametroResponse ps = new ParametroResponse();
		Boolean state = parametroService.saveParametro(pparametro);
	
		if(state){
			ps.setCode(200);
			ps.setCodeMessage("parametro creado satisfactoriamente");
		}
		return ps;
		
	}
}
