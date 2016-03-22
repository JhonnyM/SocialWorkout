package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionParqueoRequest;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionParqueoResponse;
import com.cenfotec.socialWorkout.services.PromedioOcupacionParqueoServiceInterface;
 

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/promedioOcupacionParqueo")
public class PromedioOcupacionParqueoController {
	
	@Autowired private PromedioOcupacionParqueoServiceInterface ocupacionService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public PromedioOcupacionParqueoResponse getAll(){	
		PromedioOcupacionParqueoResponse response = new PromedioOcupacionParqueoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getAll());
		return response;		
	}
	
	
}