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
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.RegistroingresoRepository;
import com.cenfotec.socialWorkout.repositories.UserRepository;
import com.cenfotec.socialWorkout.utils.Utils;



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

	@Override
	public List<RegistroingresoPOJO> getRegistroIngresoByUsuario() {
		    List<Registroingreso> registrosIngreso = new ArrayList<Registroingreso>();
		    registrosIngreso = registrarIngreso.findByUsuario1IdUsuario(Utils.getId());
	return generateRegistrosIngresoDtos(registrosIngreso);
	}

	private List<RegistroingresoPOJO> generateRegistrosIngresoDtos(List<Registroingreso> registrosIngreso){
		List<RegistroingresoPOJO> uiRegistrosIngreso = new ArrayList<RegistroingresoPOJO>();
		registrosIngreso.stream().forEach(u -> {
			UsuarioPOJO usuarioPOJOInstructor = new UsuarioPOJO();
			PlantillarutinamaestroPOJO plantillaRutinaMaestroPOJO = new PlantillarutinamaestroPOJO();
			if (!(u.getUsuario2()==null)){
			BeanUtils.copyProperties(u.getUsuario2(), usuarioPOJOInstructor);
			}
			if (!(u.getPlantillarutinamaestro()==null)){
			BeanUtils.copyProperties(u.getPlantillarutinamaestro(), plantillaRutinaMaestroPOJO);
			plantillaRutinaMaestroPOJO.setPlantillarutinamaestro(null);
			plantillaRutinaMaestroPOJO.setObjetivo(null);
			}
			RegistroingresoPOJO dto = new RegistroingresoPOJO();
			BeanUtils.copyProperties(u,dto);
			usuarioPOJOInstructor.setClave("");
			dto.setUsuario2(usuarioPOJOInstructor);
			dto.setPlantillarutinamaestro(plantillaRutinaMaestroPOJO);
			uiRegistrosIngreso.add(dto);
		});	
		return uiRegistrosIngreso;
	}

	@Override
	public List<RegistroingresoPOJO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}