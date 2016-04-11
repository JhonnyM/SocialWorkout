package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;

public interface MaquinahasejercicioServiceInterface {
	List<MaquinahasejercicioPOJO> getMaquinaHasEjercicioXIdEjercicioXMaquina(Integer idEjercicioXMaquina);
	
}
