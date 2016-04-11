package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Ocupacionactualparqueo;

public interface OcupacionActualParqueoRepository extends CrudRepository<Ocupacionactualparqueo, Integer>  {	
	List<Ocupacionactualparqueo> findAll();

}
