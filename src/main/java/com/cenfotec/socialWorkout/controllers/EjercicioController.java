package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.EjercicioResponse;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioResponse;
import com.cenfotec.socialWorkout.services.EjercicioServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/Ejercicios")
public class EjercicioController {

 @Autowired
 private EjercicioServiceInterface ejercicioService;

 @Autowired
 private HttpServletRequest request;

 @RequestMapping(value = "/getAll", method = RequestMethod.GET)
 public EjercicioResponse getAll() {
  EjercicioResponse ejercicioResponse = new EjercicioResponse();
  ejercicioResponse.setCode(200);
  ejercicioResponse.setEjercicios(ejercicioService.getAll());
  return ejercicioResponse;
 }

 @RequestMapping(value = "/create", method = RequestMethod.POST)
 public EjercicioResponse create(@RequestBody EjercicioRequest ejercicioRequest) {

  EjercicioResponse ejercicioResponse = new EjercicioResponse();
  Boolean state = ejercicioService.saveEjercicio(ejercicioRequest);

  if (state) {
   ejercicioResponse.setCode(200);
   ejercicioResponse.setCodeMessage("Ejercicio creado correctamente.");
  }
  return ejercicioResponse;

 }

 @RequestMapping(value = "/edit", method = RequestMethod.POST)
 public EjercicioResponse edit(@RequestBody EjercicioRequest ejercicioRequest) {

  EjercicioResponse ejercicioResponse = new EjercicioResponse();

  if (ejercicioService.exists(ejercicioRequest.getEjercicio().getIdEjercicio())) {
   if (ejercicioService.saveEjercicio(ejercicioRequest)) {
    ejercicioResponse.setCode(200);
    ejercicioResponse.setCodeMessage("La información del ejercicio fue modificada correctamente.");
   } else {
    ejercicioResponse.setCode(500);
    ejercicioResponse.setCodeMessage("La información del ejercicio no fue modificada.");

   }
  }
  return ejercicioResponse;
 }

 @RequestMapping(value = "/delete", method = RequestMethod.POST)
 public EjercicioResponse delete(@RequestBody EjercicioRequest ejercicioRequest) {

   EjercicioResponse ejercicioResponse = new EjercicioResponse();

   if (ejercicioService.exists(ejercicioRequest.getEjercicio().getIdEjercicio())) {
    ejercicioService.deleteAllMaquinasAsignadas(ejercicioRequest);
    if (ejercicioService.delete(ejercicioRequest.getEjercicio().getIdEjercicio())) {
     ejercicioResponse.setCode(200);
     ejercicioResponse.setCodeMessage("El unidad medida fue eliminado exitosamente");
    } else {
     ejercicioResponse.setCode(500);
     ejercicioResponse.setCodeMessage("Hubo un error al momento de eliminar la unidad");
    }

   } else {

    ejercicioResponse.setCode(404);
    ejercicioResponse.setCodeMessage("La unidad de medida no existe");
   }

   return ejercicioResponse;

  }

 @RequestMapping(value = "/assignMachine", method = RequestMethod.POST)
 public MaquinahasejercicioResponse assignMachine(@RequestBody MaquinahasejercicioRequest maquinaEjercicioRequest) {

  MaquinahasejercicioResponse maquinaEjercicioResponse = new MaquinahasejercicioResponse();
  Boolean state = ejercicioService.setMaquinaEjercicio(maquinaEjercicioRequest);

  if (state) {
   maquinaEjercicioResponse.setCode(200);
   maquinaEjercicioResponse.setCodeMessage("Ejercicio creado correctamente.");
  }
  return maquinaEjercicioResponse;

 }

 
 @RequestMapping(value = "/deleteAllAssignedMachines", method = RequestMethod.POST)
 public void deleteAllAssignedMachine(@RequestBody MaquinahasejercicioRequest maquinaEjercicioRequest) {

  ejercicioService.deleteAllMaquinasAsignadas(maquinaEjercicioRequest);

 }

 
 @RequestMapping(value = "/getMaquinasEjercicio", method = RequestMethod.POST)
 public MaquinahasejercicioResponse getMaquinasEjercicio(@RequestBody MaquinahasejercicioRequest maquinaEjercicioRequest) {
 
  MaquinahasejercicioResponse maquinaEjercicioResponse = new MaquinahasejercicioResponse();

  maquinaEjercicioResponse.setMaquinaEjercicio(ejercicioService.getMaquinasEjercicio(maquinaEjercicioRequest));

  return maquinaEjercicioResponse;

 }

}