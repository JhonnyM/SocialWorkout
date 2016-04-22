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
 public MaquinahasejercicioPOJO getMaquinahasejercicio() {
		return maquinaHasEjercicio;
	}
	
	public void setMaquinahasejercicio(MaquinahasejercicioPOJO maquinaHasEjercicio) {
		this.maquinaHasEjercicio = maquinaHasEjercicio;
	}
/* @Override
 public String toString() {
  return "MaquinaHasEjercicio request: [maquinaHasEjercicio=" + maquinaEjercicio + "]";
 }*/

}