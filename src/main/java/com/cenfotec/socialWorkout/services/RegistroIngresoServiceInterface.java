package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.RegistroIngresoRequest;
import com.cenfotec.socialWorkout.ejb.Registroingreso;
import com.cenfotec.socialWorkout.pojo.RegistroIngresoPOJO;

public interface RegistroIngresoServiceInterface {
	
	List<RegistroIngresoPOJO> getAll(RegistroIngresoRequest ir);
	List<RegistroIngresoPOJO> getAllByFechaIngreso(RegistroIngresoRequest ir);
	Boolean saveIngreso(Registroingreso pingreso);
	
}
