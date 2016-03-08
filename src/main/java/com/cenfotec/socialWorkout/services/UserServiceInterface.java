package com.cenfotec.socialWorkout.services;
import java.util.List;

import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;

public interface UserServiceInterface {
	List<UsuarioPOJO> getAll(UserRequest ur);
	List<UsuarioPOJO> getAllByName(UserRequest ur);
	Boolean saveUser(UserRequest ur);

}
