package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.ejb.Registromedida;

public interface RegistroMedidaRepository extends CrudRepository <Registromedida,Integer> {
		
	 List <Registromedida> findByUsuarioIdUsuario(int idUsuario);
	
}
