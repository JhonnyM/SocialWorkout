package com.cenfotec.socialWorkout.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Parametro;

public interface ParametroRepository extends CrudRepository<Parametro, Integer>{
	
	Parametro findByidRegistroParametro(int idRegistroParametro);
	List<Parametro> findAll();
	List<Parametro> findBynombreNegocio(String nombreNegocio);
	
}
