package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.UserRepository;

public class UserService implements UserServiceInterface {
	
@Autowired private UserRepository usersRepository;
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAll(UserRequest ur) {
		List<Usuario> users =  usersRepository.findAll();
		return generateUserDtos(users);
	}
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAllByName(UserRequest ur) {
		List<Usuario> users =  usersRepository.findBynombreContaining(ur.getSearchTerm());
		return generateUserDtos(users);
	}
	
	private List<UsuarioPOJO> generateUserDtos(List<Usuario> users){
		List<UsuarioPOJO> uiUsers = new ArrayList<UsuarioPOJO>();
		users.stream().forEach(u -> {
			UsuarioPOJO dto = new UsuarioPOJO();
			BeanUtils.copyProperties(u,dto);
			dto.setClave("");
			uiUsers.add(dto);
		});	
		return uiUsers;
	}

	@Override
	@Transactional
	public Boolean saveUser(UserRequest ur) {
	
		Usuario user = new Usuario();
		BeanUtils.copyProperties(ur.getUser(), user);
		user.setClave("set md5 password");
		
		Usuario nuser = usersRepository.save(user);
		
		return (nuser == null) ? false : true;
		
	}


}
