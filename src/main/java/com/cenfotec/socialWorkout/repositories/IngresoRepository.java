package com.cenfotec.socialWorkout.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cenfotec.socialWorkout.ejb.Registroingreso;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface IngresoRepository extends CrudRepository<Registroingreso, Integer>{

	Registroingreso findByidRegistroIngreso(int idRegistroIngreso);
	List<Registroingreso> findByFechaHoraIngreso(Date fechaHoraIngreso);
	List<Registroingreso> findByusuario1(Usuario usuario1);
	
}
