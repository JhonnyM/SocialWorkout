package com.cenfotec.socialWorkout.services;
import java.util.List;

import com.cenfotec.socialWorkout.contracts.ObjetivoRequest;
import com.cenfotec.socialWorkout.pojo.ObjetivoPOJO;
import com.cenfotec.socialWorkout.ejb.Objetivo;

public interface ObjetivoServiceInterface {
	List<ObjetivoPOJO> getAll(ObjetivoRequest or);
	Boolean saveObjetivo(Objetivo ob);
	Boolean edit(Objetivo obj);
	ObjetivoPOJO getAllByIdObjetivo(Objetivo obj);
}
