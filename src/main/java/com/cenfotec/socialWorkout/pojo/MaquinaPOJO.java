package com.cenfotec.socialWorkout.pojo;

public class MaquinaPOJO {

 private int idMaquina;

 private int cantidad;

 private String descMaquina;

 private int minutosXPersona;

 private int personasXMaquina;

 public MaquinaPOJO() {}

 public int getIdMaquina() {
  return this.idMaquina;
 }

 public void setIdMaquina(int idMaquina) {
  this.idMaquina = idMaquina;
 }

 public int getCantidad() {
  return this.cantidad;
 }

 public void setCantidad(int cantidad) {
  this.cantidad = cantidad;
 }

 public String getDescMaquina() {
  return this.descMaquina;
 }

 public void setDescMaquina(String descMaquina) {
  this.descMaquina = descMaquina;
 }

 public int getMinutosXPersona() {
  return this.minutosXPersona;
 }

 public void setMinutosXPersona(int minutosXPersona) {
  this.minutosXPersona = minutosXPersona;
 }

 public int getPersonasXMaquina() {
  return this.personasXMaquina;
 }

 public void setPersonasXMaquina(int personasXMaquina) {
  this.personasXMaquina = personasXMaquina;
 }


}