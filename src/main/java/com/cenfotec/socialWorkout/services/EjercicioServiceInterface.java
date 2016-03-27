package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;

public interface EjercicioServiceInterface {
	
	List<EjercicioPOJO> getAll();
	EjercicioPOJO getById(EjercicioRequest er);
	Boolean saveEjercicio(EjercicioRequest er);
	boolean exists(Integer idEjercicio);
	boolean delete(int idEjercicio);
	boolean setMaquinaEjercicio(EjercicioRequest er);
	void deleteMaquinasAsignadas(EjercicioRequest er);
}
