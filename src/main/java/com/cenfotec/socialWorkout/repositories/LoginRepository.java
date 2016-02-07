package com.cenfotec.socialWorkout.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cenfotec.socialWorkout.ejb.Usuario;

public interface LoginRepository extends CrudRepository<Usuario,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Usuario findByEmailAndPassword(String email, String password);
}
