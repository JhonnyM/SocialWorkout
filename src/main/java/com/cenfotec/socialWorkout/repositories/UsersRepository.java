package com.cenfotec.socialWorkout.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cenfotec.socialWorkout.ejb.Usuario;

public interface UsersRepository extends CrudRepository<Usuario,Integer> {
	
	Usuario findByEmailAndPassword(String email,String password);
	List<Usuario> findAll();
	List<Usuario> findByFirstnameContaining(String name);
}
