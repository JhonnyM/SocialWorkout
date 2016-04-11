package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Plantillarutinadetalle;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;

public interface PlantillarutinadetalleRepository  extends CrudRepository<Plantillarutinadetalle,Integer>{
	List<Plantillarutinadetalle> findAll();
	List<Plantillarutinadetalle> findByplantillarutinamaestro(Plantillarutinamaestro rutinaMaestro);
	List<Plantillarutinadetalle> findByplantillarutinamaestroIdRutina(int idRutina);
}
