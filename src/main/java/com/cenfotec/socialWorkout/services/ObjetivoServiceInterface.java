package com.cenfotec.socialWorkout.services;
import java.util.List;

import com.cenfotec.socialWorkout.contracts.ObjetivoRequest;
import com.cenfotec.socialWorkout.pojo.ObjetivoPOJO;
import com.cenfotec.socialWorkout.ejb.Objetivo;

public interface ObjetivoServiceInterface {
	List<ObjetivoPOJO> getAll();
	Objetivo getObjetivoById(int idObjetivo);
	Boolean saveObjetivo(Objetivo ob);
}
