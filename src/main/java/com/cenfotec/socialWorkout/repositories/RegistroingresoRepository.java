package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Registroingreso;

public interface RegistroingresoRepository extends CrudRepository<Registroingreso, Integer> {
	List<Registroingreso> findByUsuario1IdUsuario(int u);
	Registroingreso findByfechaHoraIngresoAndUsuario1IdUsuario(Date fecha, int u);
}
