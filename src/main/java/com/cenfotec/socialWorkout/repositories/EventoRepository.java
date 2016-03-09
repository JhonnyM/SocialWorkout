package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Evento;

public interface EventoRepository extends CrudRepository<Evento, Integer> {
	List<Evento> findAll();
}
