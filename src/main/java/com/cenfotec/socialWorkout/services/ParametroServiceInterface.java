package com.cenfotec.socialWorkout.services;

import java.util.List;
import com.cenfotec.socialWorkout.contracts.ParametroRequest;
import com.cenfotec.socialWorkout.ejb.Parametro;
import com.cenfotec.socialWorkout.pojo.ParametroPOJO;

public interface ParametroServiceInterface {
	List<ParametroPOJO> getAll(ParametroRequest pr);
	List<ParametroPOJO> getAllByName(ParametroRequest pr);
	Boolean saveParametro(Parametro pparametro);
}
