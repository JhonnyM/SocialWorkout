package com.cenfotec.socialWorkout.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;

public interface MaquinaRepository extends CrudRepository <Maquina,Integer> {

	List<Maquina> findAll();
	List<Maquina> findBymaquinahasejercicios(Maquinahasejercicio relation);
	
}
