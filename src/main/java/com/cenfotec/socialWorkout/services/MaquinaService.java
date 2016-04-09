package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.repositories.MaquinaRepository;

@Service
public class MaquinaService implements MaquinaServiceInterface {

 @Autowired
 private MaquinaRepository maquinaRepository;

 @Override
 public List <MaquinaPOJO> getAll() {

  List <Maquina> maquinas = maquinaRepository.findAll();
  return generateMaquinaDTOS(maquinas);
 }

 private List <MaquinaPOJO> generateMaquinaDTOS(List <Maquina> maquinas) {

  List <MaquinaPOJO> maquinasPOJO = new ArrayList <MaquinaPOJO> ();
  maquinas.stream().forEach(m -> {
   MaquinaPOJO dto = new MaquinaPOJO();
   BeanUtils.copyProperties(m, dto);
   maquinasPOJO.add(dto);
  });
  return maquinasPOJO;
 }

 @Override
 @Transactional
 public Boolean saveMaquina(MaquinaRequest maquinaRequest) {

  MaquinaPOJO maquinaDTO = maquinaRequest.getMaquina();
  Maquina maquina = new Maquina();
  BeanUtils.copyProperties(maquinaDTO, maquina);
  Maquina nmaquina = maquinaRepository.save(maquina);
  return (nmaquina == null) ? false : true;

 }

 @Override
 public MaquinaPOJO getById(MaquinaRequest maquinaRequest) {
  MaquinaPOJO maquinaDTO = new MaquinaPOJO();
  Maquina maquina = maquinaRepository.findOne(maquinaRequest.getMaquina().getIdMaquina());

  if (maquina != null) {
   BeanUtils.copyProperties(maquina, maquinaDTO);
  }
  return maquinaDTO;
 }

 @Override
 public boolean delete(int idMaquina) {
  maquinaRepository.delete(idMaquina);
  return !maquinaRepository.exists(idMaquina);
 }

 @Override
 public boolean exists(Integer idMaquina) {
  return maquinaRepository.exists(idMaquina);
 }

}
