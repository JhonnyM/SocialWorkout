package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.OcupacionActualParqueoRequest;
import com.cenfotec.socialWorkout.contracts.OcupacionActualParqueoResponse;
import com.cenfotec.socialWorkout.services.OcupacionActualParqueoServiceInterface;
import com.cenfotec.socialWorkout.ejb.Ocupacionactualparqueo;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/ocupacionActualParqueo")
public class OcupacionActualParqueoController {
	
	@Autowired private OcupacionActualParqueoServiceInterface ocupacionService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public OcupacionActualParqueoResponse getAll(){	
		OcupacionActualParqueoResponse response = new OcupacionActualParqueoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getAll());
		return response;		
	}
	
}