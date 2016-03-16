package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Lugarmedicion;

public interface LugarMedicionRepository  extends CrudRepository<Lugarmedicion,Integer>{
	List<Lugarmedicion> findAll();
	Lugarmedicion findByidLugarMedicion(int idLugarMedicion);


}
