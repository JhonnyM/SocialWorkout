package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Ocupacionactualgimnasio;

public interface OcupacionActualGimnasioRepository extends CrudRepository<Ocupacionactualgimnasio, Integer>  {	
	List<Ocupacionactualgimnasio> findAll();

}
