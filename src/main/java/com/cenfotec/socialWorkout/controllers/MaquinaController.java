package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.services.MaquinaServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/Maquinas")
public class MaquinaController {

	@Autowired
	private MaquinaServiceInterface maquinaService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public MaquinaResponse getAll(@RequestBody MaquinaRequest mr) {
		MaquinaResponse mre = new MaquinaResponse();
		mre.setCode(200);
		mre.setMaquinas(maquinaService.getAll(mr));
		return mre;
	}

}
