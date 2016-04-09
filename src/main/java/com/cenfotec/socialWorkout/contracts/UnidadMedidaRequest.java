package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public class UnidadMedidaRequest extends BaseRequest {

 private UnidadmedidaPOJO unidadMedida;

 public UnidadMedidaRequest() {
  super();
 }

 public UnidadmedidaPOJO getUnidadMedida() {
  return unidadMedida;
 }

 public void setUnidadMedida(UnidadmedidaPOJO unidadMedida) {
  this.unidadMedida = unidadMedida;
 }

 public String toString() {
  return "UnidadMedidaRequest [unidadMedida=" + unidadMedida + "]";
 }

}