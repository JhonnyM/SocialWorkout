package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;

public interface MaquinaServiceInterface {

	List<MaquinaPOJO> getAll(MaquinaRequest mr);
	Boolean saveMaquina(Maquina m);
	
}
