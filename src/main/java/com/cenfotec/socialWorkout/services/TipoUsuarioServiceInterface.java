package com.cenfotec.socialWorkout.services;

import java.util.List;
import java.util.Optional;

import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;

public interface TipoUsuarioServiceInterface {
	List<TipoUsuarioPOJO> getAll();
	Optional<TipoUsuarioPOJO> getTipoUsuarioById(int idTipoUsuario);
	
	boolean saveTipoUsuario(TipoUsuarioRequest r);
	boolean deleteTipoUsuario(TipoUsuarioRequest r);
}
