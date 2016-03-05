package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Objetivo;

public interface ObjetivoRepository extends CrudRepository<Objetivo, Integer> {
	List<Objetivo> findAll();
}
