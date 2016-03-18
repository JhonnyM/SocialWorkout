package com.cenfotec.socialWorkout.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;

public interface MaquinahasejercicioRepository extends CrudRepository <Maquinahasejercicio,Integer>{

    @Query(value = "SELECT MAX(m.idEjercicioXMaquina) FROM sw.maquinahasejercicio m",nativeQuery=true) 
    Integer findLastInsertedRow();
	
}
