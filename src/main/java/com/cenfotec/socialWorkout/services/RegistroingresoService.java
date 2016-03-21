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
		UsuarioPOJO usuarioDTO = request.getRegistro().getUsuario1(); 
		UsuarioPOJO InstructorDTO = request.getRegistro().getUsuario2(); 
		Registroingreso registro = new Registroingreso();
		Usuario usuario = new Usuario();
		Usuario instructor = new Usuario();
		registroDTO.setUsuario1(usuarioDTO);
		registroDTO.setUsuario2(InstructorDTO);
		BeanUtils.copyProperties(registroDTO, registro);
		BeanUtils.copyProperties(usuarioDTO, usuario);
		BeanUtils.copyProperties(InstructorDTO, instructor);
		registro.setUsuario1(usuario);
		registro.setUsuario2(instructor);
		System.out.println(registro);
		Registroingreso ri = registrarIngreso.save(registro);
		
		return !(ri == null);
	}
	
	@Override
	public boolean exists (Integer idClase){		
		return registrarIngreso.exists(idClase);		
	}

}