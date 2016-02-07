package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.UsersRequest;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;

public interface UsersServiceInterface {

	List<UsuarioPOJO> getAll(UsersRequest ur);
	List<UsuarioPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
	List<UsuarioPOJO> getAlquileres(UsersRequest ur);
}
