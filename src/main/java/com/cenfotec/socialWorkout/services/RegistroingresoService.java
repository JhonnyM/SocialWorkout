package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.RegistroingresoRequest;
import com.cenfotec.socialWorkout.ejb.Registroingreso;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.RegistroingresoRepository;
import com.cenfotec.socialWorkout.repositories.UserRepository;



@Service
public class RegistroingresoService implements RegistroingresoServiceInterface{

	@Autowired private RegistroingresoRepository registrarIngreso;
	@Autowired private UserRepository usuarioRepository;

	@Override
	public boolean save(RegistroingresoRequest request){

		RegistroingresoPOJO registroDTO = request.getRegistro();
		Registroingreso registro = new Registroingreso();
		Usuario usuario = usuarioRepository.findOne(request.getRegistro().getUsuario1().getIdUsuario());
		Usuario instructor = usuarioRepository.findOne(request.getRegistro().getUsuario2().getIdUsuario());
		if (usuario != null){
			BeanUtils.copyProperties(registroDTO, registro);
			Registroingreso ri = registrarIngreso.save(registro);
			return !(ri == null);
		}else{
			return false;
		}
		
	}
	
	@Override
	public boolean exists (Integer idClase){		
		return registrarIngreso.exists(idClase);		
	}

}