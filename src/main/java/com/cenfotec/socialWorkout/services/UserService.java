package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.UserRepository;
import com.cenfotec.socialWorkout.utils.Utils;

@Service
public class UserService implements UserServiceInterface{

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
		return users.stream()
		      .map(u -> Utils.copyProperties(u, UsuarioPOJO::new))
		      .peek(dto -> dto.setClave(""))
		      .collect(Collectors.toList());
	} 

	@Override
	@Transactional
	public boolean saveUser(UserRequest ur) {
	    Usuario user = new Usuario();
		BeanUtils.copyProperties(ur.getUser(), user);
		user.setClave("set md5 password"); 
		
		Usuario nuser = usersRepository.save(user);
		
		return nuser != null;
	}
/* este codigo se va a utilizar mas adelante para devolver la lista de rutinas de un usuario
	@Override
	@Transactional
	public List<UsuarioPOJO> getRutinas(UserRequest ur) {
		
		Usuario user = usersRepository.findOne(ur.getUser().getIdUsuario());
		
		UsuarioPOJO dtoU = user.getRutinas()
				               .stream()
				               .map(rut -> Utils.copyProperties(alq, RutinaPOJO::new))
				               .collect(Collectors.collectingAndThen(Collectors.toList(), 
				                        p -> Utils.copyProperties(user, new UsuarioPOJO(p))));
		return Arrays.asList(dtoU);
	}*/
}