package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.OcupacionActualGimnasioRequest;
import com.cenfotec.socialWorkout.contracts.OcupacionActualGimnasioResponse;
import com.cenfotec.socialWorkout.services.OcupacionActualGimnasioServiceInterface;
import com.cenfotec.socialWorkout.ejb.Ocupacionactualgimnasio;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/ocupacionActual")
public class OcupacionActualGimnasioController {
	
	@Autowired private OcupacionActualGimnasioServiceInterface ocupacionService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public OcupacionActualGimnasioResponse getAll(){	
		OcupacionActualGimnasioResponse response = new OcupacionActualGimnasioResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getAll());
		return response;		
	}
	
	
}