package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Plantillarutinadetalle;

public interface PlantillarutinadetalleRepository  extends CrudRepository<Plantillarutinadetalle,Integer>{
	List<Plantillarutinadetalle> findAll();

}
