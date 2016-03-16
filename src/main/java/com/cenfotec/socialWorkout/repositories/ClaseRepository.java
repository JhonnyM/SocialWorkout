package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Clase;

public interface ClaseRepository extends CrudRepository<Clase, Integer> {
	List<Clase> findAll();
}
