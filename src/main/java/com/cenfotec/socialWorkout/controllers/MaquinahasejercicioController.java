package com.cenfotec.socialWorkout.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.EjercicioResponse;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioResponse;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/protected/Maquinahasejercicios")
public class MaquinahasejercicioController {

	
}
