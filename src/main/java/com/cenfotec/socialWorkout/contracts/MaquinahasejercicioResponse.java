package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public class MaquinahasejercicioResponse extends BaseResponse {

// private List < MaquinahasejercicioPOJO > maquinaEjercicio;
 private List<MaquinahasejercicioPOJO> maquinaHasEjercicio;

 public MaquinahasejercicioResponse() {
  super();
 }

/* public List < MaquinahasejercicioPOJO > getMaquinaEjercicio() {
  return maquinaEjercicio;
 }

 public void setMaquinaEjercicio(List < MaquinahasejercicioPOJO > maquinaEjercicio) {
  this.maquinaEjercicio = maquinaEjercicio;
 }*/
 public List<MaquinahasejercicioPOJO> getMaquinahasejercicio() {
		return maquinaHasEjercicio;
	}

	public void setMaquinahasejercicio(List<MaquinahasejercicioPOJO> maquinaHasEjercicio) {
		this.maquinaHasEjercicio = maquinaHasEjercicio;
	}

}