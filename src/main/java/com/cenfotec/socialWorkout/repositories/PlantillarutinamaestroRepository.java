package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;

public interface PlantillarutinamaestroRepository  extends CrudRepository<Plantillarutinamaestro,Integer>{
	List<Plantillarutinamaestro> findAll();

}
