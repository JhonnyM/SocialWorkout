package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionParqueoPOJO;

public interface PromedioOcupacionParqueoServiceInterface {
	List<PromedioOcupacionParqueoPOJO> getAll();
	List<PromedioOcupacionParqueoPOJO> getDia(String dia, int hora);
	List<PromedioOcupacionParqueoPOJO>  getDiaTotal(String dia);
}
