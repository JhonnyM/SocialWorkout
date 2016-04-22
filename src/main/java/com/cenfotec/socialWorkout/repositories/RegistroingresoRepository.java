package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Registroingreso;

public interface RegistroingresoRepository extends CrudRepository<Registroingreso, Integer> {
	List<Registroingreso> findByUsuario1IdUsuario(int u);
	
	@Query(value="Select * From Sw.RegistroIngreso R Where idUsuario = :idUsuario Order By FechaHoraIngreso Desc Limit 1",nativeQuery=true)
	Registroingreso getLastRegistroIngreso(@Param("idUsuario") int idUsuario);

	Registroingreso findByfechaHoraIngresoAndUsuario1IdUsuario(Date fecha, int u);
}
