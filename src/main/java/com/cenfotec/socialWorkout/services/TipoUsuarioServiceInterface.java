package com.cenfotec.socialWorkout.services;

import java.util.List;
import java.util.Optional;

import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.ejb.Tipousuario;

public interface TipoUsuarioServiceInterface {
	TipoUsuarioPOJO getTipoUsuarioById(int idTipoUsuario);
	List<TipoUsuarioPOJO> getAll();
	Boolean saveTipoUsuario(TipoUsuarioRequest tipoUsuarioRequest);
	Boolean edit(TipoUsuarioRequest tipoUsuarioRequest);
	public boolean delete(Integer idObj);
	public boolean exists (Integer idObj);
	TipoUsuarioPOJO getTipoUsuarioByDescTipoUsuario(String descTipoUsuario);
	
}