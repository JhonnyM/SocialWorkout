package com.cenfotec.socialWorkout.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Maquina;

public interface MaquinaRepository extends CrudRepository <Maquina,Integer> {

	List<Maquina> findAll();
	
}

