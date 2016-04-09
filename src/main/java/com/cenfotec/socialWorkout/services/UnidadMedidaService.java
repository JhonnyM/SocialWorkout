package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.repositories.UnidadMedidaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService implements UnidadMedidaServiceInterface {

 @Autowired
 private UnidadMedidaRepository unidadMedidaRepository;

 @Override
 public List < UnidadmedidaPOJO > getAll() {

  List < Unidadmedida > unidadesMedidas = unidadMedidaRepository.findAll();
  return generateUnidadMedidaDTOS(unidadesMedidas);
 }

 private List < UnidadmedidaPOJO > generateUnidadMedidaDTOS(List < Unidadmedida > unidadesMedidas) {

  List < UnidadmedidaPOJO > unidadesMedidasPOJO = new ArrayList < UnidadmedidaPOJO > ();
  unidadesMedidas.stream().forEach(um -> {
   UnidadmedidaPOJO dto = new UnidadmedidaPOJO();
   BeanUtils.copyProperties(um, dto);

   unidadesMedidasPOJO.add(dto);
  });
  return unidadesMedidasPOJO;
 }

 @Override
 @Transactional
 public Boolean saveUnidadMedida(UnidadMedidaRequest unidadMedidaRequest) {

  UnidadmedidaPOJO unidadMedidaDTO = unidadMedidaRequest.getUnidadMedida();
  Unidadmedida unidadMedida = new Unidadmedida();
  BeanUtils.copyProperties(unidadMedidaDTO, unidadMedida);
  Unidadmedida unidadMedidaEJB = unidadMedidaRepository.save(unidadMedida);
  return (unidadMedidaEJB == null) ? false : true;

 }

 @Override
 public UnidadmedidaPOJO getById(UnidadMedidaRequest unidadMedidaRequest) {

  UnidadmedidaPOJO unidadMedidaDTO = new UnidadmedidaPOJO();
  Unidadmedida unidadMedida = unidadMedidaRepository.findOne(unidadMedidaRequest.getUnidadMedida().getIdUnidadMedida());

  if (unidadMedida != null) {
   BeanUtils.copyProperties(unidadMedida, unidadMedidaDTO);
  }

  return unidadMedidaDTO;

 }

 @Override
 public boolean delete(int idUnidadMedida) {
  unidadMedidaRepository.delete(idUnidadMedida);
  return !unidadMedidaRepository.exists(idUnidadMedida);
 }

 @Override
 public boolean exists(Integer idUnidadMedida) {
  return unidadMedidaRepository.exists(idUnidadMedida);

 }

 @Override
 public UnidadmedidaPOJO getByIdUnidad(int idUnidadMedida) {
  UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
  Unidadmedida unidadMedida = unidadMedidaRepository.findByIdUnidadMedida(idUnidadMedida);
  if (unidadMedida != null) {
   BeanUtils.copyProperties(unidadMedida, unidadMedidaPOJO);
  }
  return unidadMedidaPOJO;
 }

}