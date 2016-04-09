package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public class MaquinahasejercicioRequest {

 private MaquinahasejercicioPOJO maquinaEjercicio;

 public MaquinahasejercicioRequest() {
  super();
 }

 public MaquinahasejercicioPOJO getMaquinaEjercicio() {
  return this.maquinaEjercicio;
}

 public void setMaquinaEjercicio(MaquinahasejercicioPOJO maquinaEjercicio) {
  this.maquinaEjercicio = maquinaEjercicio;
 }

 @Override
 public String toString() {
  return "MaquinaHasEjercicio request: [maquinaHasEjercicio=" + maquinaEjercicio + "]";
 }

}