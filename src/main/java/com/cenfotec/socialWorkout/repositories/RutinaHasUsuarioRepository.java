package com.cenfotec.socialWorkout.repositories;
import java.sql.Time;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Rutinahasusuario;

public interface RutinaHasUsuarioRepository extends CrudRepository<Rutinahasusuario, Integer>  {	
	List<Rutinahasusuario> findAll();
   // List<Rutinahasusuario> findBydiaSemanalAgendadoAndhora(String dia, Time hora);
}
