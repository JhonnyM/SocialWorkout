package com.cenfotec.socialWorkout.services;
import java.util.List;

import com.cenfotec.socialWorkout.contracts.UserAdministradorRequest;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.UsuarioAdministradorPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;

public interface UserServiceInterface {
	List<UsuarioPOJO> getAll(UserRequest ur);
	List<UsuarioPOJO> getAllByName(UserRequest ur);
	List<UsuarioAdministradorPOJO> getAllToAdministrador(UserAdministradorRequest ur);
	boolean saveUser(UserRequest usuarioRequest);
	Boolean edit(UserRequest usuarioRequest);
	List<UsuarioPOJO> getAllByTipoUsuario();
	UsuarioPOJO getUsuarioInstructorById(int idUsuario);
	List<UsuarioPOJO> getInstructores();
	public List<UsuarioPOJO> getAll();
	UsuarioPOJO getUsuarioSession();
	

}
