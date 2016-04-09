package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;

public interface MaquinaServiceInterface {

 List <MaquinaPOJO> getAll();

 MaquinaPOJO getById(MaquinaRequest maquinaRequest);

 Boolean saveMaquina(MaquinaRequest maquinaRequest);

 public boolean delete(int idMaquina);

 public boolean exists(Integer idMaquina);

}