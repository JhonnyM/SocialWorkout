package com.cenfotec.socialWorkout.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaResponse;
import com.cenfotec.socialWorkout.services.UnidadMedidaServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/UnidadesMedidas")
public class UnidadMedidaController {

 @Autowired
 private UnidadMedidaServiceInterface unidadMedidaService;
 @Autowired
 private HttpServletRequest request;

 @RequestMapping(value = "/getAll", method = RequestMethod.GET)
 public UnidadMedidaResponse getAll() {
  UnidadMedidaResponse unidadMedidaResponse = new UnidadMedidaResponse();
  unidadMedidaResponse.setCode(200);
  unidadMedidaResponse.setUnidadesMedidas(unidadMedidaService.getAll());
  return unidadMedidaResponse;
 }

 @RequestMapping(value = "/create", method = RequestMethod.POST)
 public UnidadMedidaResponse create(@RequestBody UnidadMedidaRequest unidadMedidaRequest) {

  UnidadMedidaResponse unidadMedidaResponse = new UnidadMedidaResponse();
  Boolean state = unidadMedidaService.saveUnidadMedida(unidadMedidaRequest);

  if (state) {
   unidadMedidaResponse.setCode(200);
   unidadMedidaResponse.setCodeMessage("Unidad de medida registrada correctamente.");
  }
  return unidadMedidaResponse;
 }

 @RequestMapping(value = "/edit", method = RequestMethod.POST)
 public UnidadMedidaResponse edit(@RequestBody UnidadMedidaRequest unidadMedidaRequest) {

  UnidadMedidaResponse unidadMedidaResponse = new UnidadMedidaResponse();

  if (unidadMedidaService.exists(unidadMedidaRequest.getUnidadMedida().getIdUnidadMedida())) {
   if (unidadMedidaService.saveUnidadMedida(unidadMedidaRequest)) {
    unidadMedidaResponse.setCode(200);
    unidadMedidaResponse.setCodeMessage("La información de la unidad de medida fue modificada correctamente.");
   } else {
    unidadMedidaResponse.setCode(500);
    unidadMedidaResponse.setCodeMessage("La información de la unidad de medida no fue modificada correctamente.");

   }
  }
  return unidadMedidaResponse;

 }

 @RequestMapping(value = "/delete", method = RequestMethod.POST)
 public UnidadMedidaResponse delete(@RequestBody UnidadMedidaRequest unidadMedidaRequest) {

  UnidadMedidaResponse unidadMedidaResponse = new UnidadMedidaResponse();

  if (unidadMedidaService.exists(unidadMedidaRequest.getUnidadMedida().getIdUnidadMedida())) {
   if (unidadMedidaService.delete(unidadMedidaRequest.getUnidadMedida().getIdUnidadMedida())) {
    unidadMedidaResponse.setCode(200);
    unidadMedidaResponse.setCodeMessage("El unidad medida fue eliminado exitosamente");
   } else {
    unidadMedidaResponse.setCode(500);
    unidadMedidaResponse.setCodeMessage("Hubo un error al momento de eliminar la unidad");
   }

  } else {
   unidadMedidaResponse.setCode(404);
   unidadMedidaResponse.setCodeMessage("La unidad de medida no existe");
  }

  return unidadMedidaResponse;

 }

}