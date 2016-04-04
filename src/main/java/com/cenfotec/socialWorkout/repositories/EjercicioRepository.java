package com.cenfotec.socialWorkout.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;

public interface EjercicioRepository extends CrudRepository <Ejercicio,Integer>{
	
	List<Ejercicio> findAll();
	List<Ejercicio> findBymaquinahasejercicios(Maquinahasejercicio relation);

}
