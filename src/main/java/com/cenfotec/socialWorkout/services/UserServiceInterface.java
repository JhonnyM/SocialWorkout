package com.cenfotec.socialWorkout.services;
import java.util.List;

import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;

public interface UserServiceInterface {
	List<UsuarioPOJO> getAll(UserRequest ur);
	List<UsuarioPOJO> getAllByName(UserRequest ur);
	boolean saveUser(Usuario usuario);
	Boolean edit(Usuario usuarioDTO);
	

}
