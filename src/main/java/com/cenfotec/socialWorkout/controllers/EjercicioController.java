package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.services.EjercicioServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/Ejercicios")
public class EjercicioController {

	@Autowired private EjercicioServiceInterface ejercicioService;
	@Autowired private HttpServletRequest request;
	
}
