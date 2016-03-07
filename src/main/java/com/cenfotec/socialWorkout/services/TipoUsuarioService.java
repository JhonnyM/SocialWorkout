package com.cenfotec.socialWorkout.services;

import java.beans.Beans;
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
	public Boolean saveTipoUsuario(Tipousuario tipoUsuario) {
	BeanUtils.copyProperties(tipoUsuario.getDescTipoUsuario(), tipoUsuario);		
		Tipousuario nTipoUsuario = tipoUsuarioRepository.save(tipoUsuario);		
		return (nTipoUsuario == null) ? false : true;
	}
	
	@Override
	public TipoUsuarioPOJO getAllByIdTipoUsuario(Tipousuario tip) {
		Tipousuario tipoUsuario;
		TipoUsuarioPOJO uiTipoUsuario = new TipoUsuarioPOJO();
		tipoUsuario =  tipoUsuarioRepository.findOne(tip.getIdTipoUsuario());
		BeanUtils.copyProperties(tip,tipoUsuario);
		BeanUtils.copyProperties(tipoUsuario,uiTipoUsuario);
		return uiTipoUsuario;
	}
	
	@Override
	@Transactional
	public Boolean edit(Tipousuario tip){
		TipoUsuarioPOJO tipoUsuarioPOJO = this.getAllByIdTipoUsuario(tip);
		Tipousuario eTipoUsuario = new Tipousuario();
		BeanUtils.copyProperties(tipoUsuarioPOJO,eTipoUsuario);
		Tipousuario nTipoUsuario = tipoUsuarioRepository.save(eTipoUsuario);
		return (nTipoUsuario == null) ? false : true;

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
	public Tipousuario getTipoUsuarioById(int idTipoUsuario) {
		return tipoUsuarioRepository.findOne(idTipoUsuario);
	}

	@Transactional
	public TipoUsuarioPOJO getTipoUsuarioByDescTipoUsuario(String descTipoUsuario) {
		TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
		Utils.copyProperties(tipoUsuarioRepository.findBydescTipoUsuario(descTipoUsuario)
				, tipoUsuarioPOJO);
	return tipoUsuarioPOJO;
	}
}
