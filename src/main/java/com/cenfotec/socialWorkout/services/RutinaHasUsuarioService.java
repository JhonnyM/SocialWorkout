package com.cenfotec.socialWorkout.services;

import java.beans.Beans;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.RutinaHasUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.UserRequest;

import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.RutinaHasUsuarioRepository;
import com.cenfotec.socialWorkout.repositories.TipoUsuarioRepository;
import com.cenfotec.socialWorkout.utils.Utils;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.ejb.Rutinahasusuario;
import com.cenfotec.socialWorkout.ejb.Tipousuario;
import com.cenfotec.socialWorkout.ejb.Usuario;

@Service
public class RutinaHasUsuarioService implements RutinaHasUsuarioServiceInterface {
	
@Autowired private RutinaHasUsuarioRepository rutinaHasUsuarioRepository;
@Autowired private PlantillarutinamaestroServiceInterface plantillaService;



	@Override
	@Transactional
	public Boolean actualizaRutinaTemporal(int idRutinaHasUsuario, int temporal){
		Rutinahasusuario rutinaHasUsuario = new Rutinahasusuario();
		RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO = new RutinaHasUsuarioPOJO();
		Usuario usuario = new Usuario();
		Plantillarutinamaestro plantillaRutinaMaestro = new Plantillarutinamaestro();
		UsuarioPOJO usuarioPOJO = new UsuarioPOJO();
		PlantillarutinamaestroPOJO plantillaRutinaMaestroPOJO = new PlantillarutinamaestroPOJO();
		
		rutinaHasUsuario = rutinaHasUsuarioRepository.findByIdRegistroRutinaXUsuario(idRutinaHasUsuario);
		usuario = rutinaHasUsuario.getUsuario();
		plantillaRutinaMaestro = rutinaHasUsuario.getPlantillarutinamaestro();
		
		BeanUtils.copyProperties(rutinaHasUsuario,rutinaHasUsuarioPOJO);
		BeanUtils.copyProperties(usuario,usuarioPOJO);
		BeanUtils.copyProperties(plantillaRutinaMaestro,plantillaRutinaMaestroPOJO);
		rutinaHasUsuarioPOJO.setUsuario(usuarioPOJO);
		rutinaHasUsuarioPOJO.setPlantillarutinamaestroPOJO(plantillaRutinaMaestroPOJO);
	    rutinaHasUsuarioPOJO.setTemporal(temporal);
	    BeanUtils.copyProperties(rutinaHasUsuarioPOJO,rutinaHasUsuario);
	    Rutinahasusuario nRutinaHasUsuario = rutinaHasUsuarioRepository.save(rutinaHasUsuario);
		return (nRutinaHasUsuario == null) ? false : true;
	}

	@Override
	public List<RutinaHasUsuarioPOJO> getRutinaDia(String dia, UsuarioPOJO usuarioPOJO) {
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioPOJO,usuario);
		List<Rutinahasusuario> rutinaHasUsuarios = new ArrayList<Rutinahasusuario>();
		rutinaHasUsuarios = rutinaHasUsuarioRepository.findByDiaSemanalAgendadoAndUsuario(dia, usuario);
		return  generateRutinaHasUsuarioDtos(rutinaHasUsuarios);
	}

	@Override
	public List<RutinaHasUsuarioPOJO> getRutinaWithPlantilla(String dia, UsuarioPOJO usuarioPOJO) {
		Usuario usuario = new Usuario();
	
		BeanUtils.copyProperties(usuarioPOJO,usuario);
		List<Rutinahasusuario> rutinaHasUsuarios = new ArrayList<Rutinahasusuario>();
		rutinaHasUsuarios = rutinaHasUsuarioRepository.findByDiaSemanalAgendadoAndUsuario(dia, usuario);
		List<RutinaHasUsuarioPOJO> uiRutinasHasUsuarios = new ArrayList<RutinaHasUsuarioPOJO>();
		
		rutinaHasUsuarios.stream().forEach(u -> {
		 	Integer idRutina = u.getTemporal();
		 	System.out.println(idRutina+"");
		 	Plantillarutinamaestro plantillaMaestro = new Plantillarutinamaestro();
			PlantillarutinamaestroPOJO plantillaDTO = new PlantillarutinamaestroPOJO();
		 	if (idRutina==0){
		 		plantillaMaestro = u.getPlantillarutinamaestro();
		 		plantillaMaestro.setPlantillarutinamaestros(null);
		 		plantillaMaestro.setPlantillarutinadetalles(null);
		 		plantillaMaestro.setRutinahasusuarios(null);
				BeanUtils.copyProperties(plantillaMaestro,plantillaDTO);
		 	}else{
		 		PlantillarutinamaestroPOJO pmPOJO = new PlantillarutinamaestroPOJO();
		 		pmPOJO = plantillaService.getRutinaXId(idRutina);
		 		pmPOJO.setPlantillarutinadetalles(null);
		 		pmPOJO.setPlantillarutinamaestros(null);
				BeanUtils.copyProperties(pmPOJO,plantillaDTO);
		 	}
			RutinaHasUsuarioPOJO dto = new RutinaHasUsuarioPOJO();
			BeanUtils.copyProperties(u,dto);
			plantillaDTO.setObjetivo(null);
			dto.setPlantillarutinamaestroPOJO(plantillaDTO);
			uiRutinasHasUsuarios.add(dto);
		});	
		return uiRutinasHasUsuarios;
		}
	
	@Override
	public List<RutinaHasUsuarioPOJO> getRutinaWithPlantillaUsuario(UsuarioPOJO usuarioPOJO) {
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioPOJO,usuario);
		List<Rutinahasusuario> rutinaHasUsuarios = new ArrayList<Rutinahasusuario>();
		rutinaHasUsuarios = rutinaHasUsuarioRepository.findByUsuario(usuario);
		List<RutinaHasUsuarioPOJO> uiRutinasHasUsuarios = new ArrayList<RutinaHasUsuarioPOJO>();
		rutinaHasUsuarios.stream().forEach(u -> {
			Plantillarutinamaestro plantillaMaestro = new Plantillarutinamaestro();
			PlantillarutinamaestroPOJO plantillaDTO = new PlantillarutinamaestroPOJO();
			plantillaMaestro = u.getPlantillarutinamaestro();
			plantillaMaestro.setPlantillarutinadetalles(null);
			plantillaMaestro.setPlantillarutinamaestros(null);
			plantillaMaestro.setRutinahasusuarios(null);
			BeanUtils.copyProperties(plantillaMaestro,plantillaDTO);
			RutinaHasUsuarioPOJO dto = new RutinaHasUsuarioPOJO();
			BeanUtils.copyProperties(u,dto);
			plantillaDTO.setObjetivo(null);
			dto.setPlantillarutinamaestroPOJO(plantillaDTO);
			uiRutinasHasUsuarios.add(dto);
		});	
		return uiRutinasHasUsuarios;
		}
	
	
	private List<RutinaHasUsuarioPOJO> generateRutinaHasUsuarioDtos(List<Rutinahasusuario> rutinaHasUsuarios){
		List<RutinaHasUsuarioPOJO> uiRutinasHasUsuarios = new ArrayList<RutinaHasUsuarioPOJO>();
		rutinaHasUsuarios.stream().forEach(u -> {
			RutinaHasUsuarioPOJO dto = new RutinaHasUsuarioPOJO();
			BeanUtils.copyProperties(u,dto);
			uiRutinasHasUsuarios.add(dto);
		});	
		return uiRutinasHasUsuarios;
	}

}
