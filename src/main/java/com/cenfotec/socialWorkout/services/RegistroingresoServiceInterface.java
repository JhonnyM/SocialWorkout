package com.cenfotec.socialWorkout.services;

import java.util.List;


import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;
import com.cenfotec.socialWorkout.contracts.RegistroingresoRequest;

public interface RegistroingresoServiceInterface {

	public RegistroingresoPOJO getById(RegistroingresoRequest request);
	public boolean exists (Integer id);
	public boolean save(RegistroingresoRequest request);
}
