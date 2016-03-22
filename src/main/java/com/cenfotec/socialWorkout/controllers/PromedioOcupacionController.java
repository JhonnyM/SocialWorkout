package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionRequest;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionResponse;
import com.cenfotec.socialWorkout.services.PromedioOcupacionServiceInterface;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/promedioOcupacion")
public class PromedioOcupacionController {
	
	@Autowired private PromedioOcupacionServiceInterface ocupacionService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public PromedioOcupacionResponse getAll(){	
		PromedioOcupacionResponse response = new PromedioOcupacionResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getAll());
		return response;		
	}
	
	@RequestMapping(value ="/getDia", method = RequestMethod.POST)
	public PromedioOcupacionResponse getDia(){	
		PromedioOcupacionResponse response = new PromedioOcupacionResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getDia("Monday", 11));
		return response;		
	}
	
}