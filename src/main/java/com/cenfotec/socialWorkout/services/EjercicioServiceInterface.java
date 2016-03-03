package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;

public interface EjercicioServiceInterface {
	
	List<EjercicioPOJO> getAll(EjercicioRequest er);
	Boolean saveEjercicio(Ejercicio e);

}
