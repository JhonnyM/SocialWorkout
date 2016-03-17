package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.RegistroingresoRequest;
import com.cenfotec.socialWorkout.ejb.Registroingreso;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;
import com.cenfotec.socialWorkout.repositories.RegistroingresoRepository;



@Service
public class RegistroingresoService implements RegistroingresoServiceInterface{

	@Autowired private RegistroingresoRepository registrarIngreso;
	
	@Override
	public RegistroingresoPOJO getById(RegistroingresoRequest request) {
		RegistroingresoPOJO ri = new RegistroingresoPOJO();
		Registroingreso registro = registrarIngreso.findOne(request.getRegistro().getIdRegistroIngreso());
		
		if(registro != null)
		{
			BeanUtils.copyProperties(registro, ri);
		}
		return ri;
	}

	@Override
	public boolean save(RegistroingresoRequest request){
		RegistroingresoPOJO eventoDTO = request.getRegistro();
		Registroingreso registro = new Registroingreso();
		BeanUtils.copyProperties(eventoDTO, registro);
		Registroingreso ri = registrarIngreso.save(registro);
		return !(ri == null);
		
	}
	
	@Override
	public boolean exists (Integer idClase){		
		return registrarIngreso.exists(idClase);		
	}

}