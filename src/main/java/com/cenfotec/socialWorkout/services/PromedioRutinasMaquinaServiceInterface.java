package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.ejb.Promedioocupacion;
import com.cenfotec.socialWorkout.ejb.Promediorutinasmaquina;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;

public interface PromedioRutinasMaquinaServiceInterface {
	List<PromedioRutinasMaquinaPOJO> getAll();
    List<PromedioRutinasMaquinaPOJO> getOcupacionXDiaHora(String dia, int hora);
	List<PromedioRutinasMaquinaPOJO>  getOcupacionXDiaTotal(String dia);
	PromedioRutinasMaquinaPOJO getOcupacionXDiaHoraMaquina(int codigoMaquina,String dia, int hora);
	List<PromedioRutinasMaquinaPOJO> getOcupacionXMaquinaDia(int codigoMaquina,String dia);

}
