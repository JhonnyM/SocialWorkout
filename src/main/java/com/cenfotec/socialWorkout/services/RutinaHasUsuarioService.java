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
import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
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
			Plantillarutinamaestro plantillaMaestro = new Plantillarutinamaestro();
			PlantillarutinamaestroPOJO plantillaDTO = new PlantillarutinamaestroPOJO();
			plantillaMaestro = u.getPlantillarutinamaestro();
			BeanUtils.copyProperties(plantillaMaestro,plantillaDTO);
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
