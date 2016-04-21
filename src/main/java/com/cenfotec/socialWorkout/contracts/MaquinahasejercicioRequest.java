package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public class MaquinahasejercicioRequest {

 //private MaquinahasejercicioPOJO maquinaEjercicio;
 private MaquinahasejercicioPOJO maquinaHasEjercicio;
 
 public MaquinahasejercicioRequest() {
  super();
 }

 /*public MaquinahasejercicioPOJO getMaquinaEjercicio() {
  return this.maquinaEjercicio;
}

 public void setMaquinaEjercicio(MaquinahasejercicioPOJO maquinaEjercicio) {
  this.maquinaEjercicio = maquinaEjercicio;
 }*/
 public MaquinahasejercicioPOJO getMaquinaHasEjercicio() {
		return maquinaHasEjercicio;
	}
	
	public void setMaquinaHasEjercicio(MaquinahasejercicioPOJO maquinaHasEjercicio) {
		this.maquinaHasEjercicio = maquinaHasEjercicio;
	}
/* @Override
 public String toString() {
  return "MaquinaHasEjercicio request: [maquinaHasEjercicio=" + maquinaEjercicio + "]";
 }*/

}