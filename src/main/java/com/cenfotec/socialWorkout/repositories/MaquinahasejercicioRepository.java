package com.cenfotec.socialWorkout.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;

public interface MaquinahasejercicioRepository extends CrudRepository <Maquinahasejercicio,Integer>{

 List <Maquinahasejercicio> findByEjercicioIdEjercicio(int idEjercicio);
 List <Maquinahasejercicio> findByIdEjercicioXMaquina(Integer idEjercicioXMaquina);
	
}
