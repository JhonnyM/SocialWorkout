package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Registroingreso;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface RegistroingresoRepository extends CrudRepository<Registroingreso, Integer> {
	List<Registroingreso> findByUsuario1(Usuario usuario);
}
