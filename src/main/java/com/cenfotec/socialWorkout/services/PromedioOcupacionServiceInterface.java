package com.cenfotec.socialWorkout.services;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;

public interface PromedioOcupacionServiceInterface {
	List<PromedioOcupacionPOJO> getAll();
    List<PromedioOcupacionPOJO> getDia(String dia, int hora);
}
