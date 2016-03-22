package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Promedioocupacion;

public interface PromedioOcupacionRepository extends CrudRepository<Promedioocupacion, Integer>  {	
	List<Promedioocupacion> findAll();
	List<Promedioocupacion>  findByDiaAndHora(String dia, int hora);
}
