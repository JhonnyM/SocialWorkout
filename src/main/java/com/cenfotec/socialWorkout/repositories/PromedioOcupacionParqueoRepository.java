package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Promedioocupacionparqueo;

public interface PromedioOcupacionParqueoRepository extends CrudRepository<Promedioocupacionparqueo, Integer>  {	
	List<Promedioocupacionparqueo> findAll();

}
