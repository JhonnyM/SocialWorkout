package com.cenfotec.socialWorkout.repositories;

import java.util.List;
import javax.persistence.criteria.CriteriaUpdate;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Parametro;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface ParametroRepository extends CrudRepository<Parametro, Integer>{
	
	Parametro findByidRegistroParametro(int idRegistroParametro);
	List<Parametro> findAll();
	List<Parametro> findBynombreNegocio(String nombreNegocio);
	
}
