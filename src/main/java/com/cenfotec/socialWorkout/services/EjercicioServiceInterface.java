package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioResponse;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public interface EjercicioServiceInterface {
	
	List<EjercicioPOJO> getAll();
	EjercicioPOJO getById(EjercicioRequest er);
	Boolean saveEjercicio(EjercicioRequest er);
	boolean exists(Integer idEjercicio);
	boolean delete(int idEjercicio);
	boolean setMaquinaEjercicio(MaquinahasejercicioRequest maquinaEjercicioRequest);
	void deleteMaquinasAsignadas(MaquinahasejercicioRequest maquinaEjercicioRequest);
	List<MaquinahasejercicioPOJO> getMaquinasEjercicio(MaquinahasejercicioRequest maquinaEjercicioRequest);
	void deleteAllMaquinasAsignadas(MaquinahasejercicioRequest maquinaEjercicioRequest);
	void deleteAllMaquinasAsignadas(EjercicioRequest ejercicioRequest);
}
