package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.cenfotec.socialWorkout.ejb.Evento;
import com.cenfotec.socialWorkout.ejb.Registroingreso;

public interface EventoRepository extends CrudRepository<Evento, Integer> {
	List<Evento> findAll();
	
	@Query(value="SELECT * FROM SW.Eventos WHERE FechaHoraInicio >= now()",nativeQuery=true)
	List<Evento> getAllPendingEvents();

}
