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
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.TipoUsuarioRepository;
import com.cenfotec.socialWorkout.utils.Utils;
import com.cenfotec.socialWorkout.ejb.Tipousuario;
import com.cenfotec.socialWorkout.ejb.Usuario;

@Service
public class TipoUsuarioService implements TipoUsuarioServiceInterface {
	
@Autowired private TipoUsuarioRepository tipoUsuarioRepository;
	
	@Override
	@Transactional
	public List<TipoUsuarioPOJO> getAll() {
		List<Tipousuario> tiposUsuarios =  tipoUsuarioRepository.findAll();
		return generateTiposUsuariosDtos(tiposUsuarios);
	}

	private List<TipoUsuarioPOJO> generateTiposUsuariosDtos(List<Tipousuario> tiposUsuarios){
		List<TipoUsuarioPOJO> uiTiposUsuarios = new ArrayList<TipoUsuarioPOJO>();
		tiposUsuarios.stream().forEach(u -> {
			TipoUsuarioPOJO dto = new TipoUsuarioPOJO();
			BeanUtils.copyProperties(u,dto);
			uiTiposUsuarios.add(dto);
		});	
		return uiTiposUsuarios;
	}

	@Override
	@Transactional
	public Boolean saveTipoUsuario(TipoUsuarioRequest tipoUsuarioRequest) {
		Tipousuario tipoUsuario = new Tipousuario();
		Utils.copyProperties(tipoUsuarioRequest.getTipo(), tipoUsuario);
		Tipousuario ntuser = tipoUsuarioRepository.save(tipoUsuario);
		return ntuser != null;
	}
	
	@Override
	@Transactional
	public Boolean edit(TipoUsuarioRequest tipoUsuarioRequest){
		Tipousuario tipoUsuario = new Tipousuario();
		System.out.println(tipoUsuarioRequest.getTipo().getDescTipoUsuario());
		Utils.copyProperties(tipoUsuarioRequest.getTipo(), tipoUsuario);
		Tipousuario ntuser = tipoUsuarioRepository.save(tipoUsuario);
		return ntuser != null;
	}


	@Override
	public boolean exists (Integer idObj){
		return tipoUsuarioRepository.exists(idObj);
	}

	@Override
	public boolean delete(Integer idObj) {
		tipoUsuarioRepository.delete(idObj);
		return !tipoUsuarioRepository.exists(idObj);
		
	}

	@Override
	@Transactional
	public TipoUsuarioPOJO getTipoUsuarioById(int idTipoUsuario) {
		TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
		Utils.copyProperties(tipoUsuarioRepository.findByidTipoUsuario(idTipoUsuario),tipoUsuarioPOJO);
		return tipoUsuarioPOJO;
	}

	@Transactional
	public TipoUsuarioPOJO getTipoUsuarioByDescTipoUsuario(String descTipoUsuario) {
		TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
		Utils.copyProperties(tipoUsuarioRepository.findBydescTipoUsuario(descTipoUsuario)
				, tipoUsuarioPOJO);
	return tipoUsuarioPOJO;
	}
}
