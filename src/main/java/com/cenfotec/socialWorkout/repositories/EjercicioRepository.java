package com.cenfotec.socialWorkout.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Ejercicio;

public interface EjercicioRepository extends CrudRepository <Ejercicio,Integer>{
	
	List<Ejercicio> findAll();

}
