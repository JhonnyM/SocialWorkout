package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.RegistroMedidaRequest;
import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;

public interface RegistroMedidaServiceInterface {

	List<RegistroMedidaPOJO> getAllById(RegistroMedidaRequest rmR);
	
}
