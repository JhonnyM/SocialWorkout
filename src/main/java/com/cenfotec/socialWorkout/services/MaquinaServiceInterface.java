package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;

public interface MaquinaServiceInterface {

	List<MaquinaPOJO> getAll(MaquinaRequest mr);

	Maquina getAllByIdMaquina(Maquina m);
	
	Boolean saveMaquina(Maquina m);

	Boolean editMaquina(Maquina m);

	public boolean delete(int idMaquina);

	public boolean exists(Integer idMaquina);

}
