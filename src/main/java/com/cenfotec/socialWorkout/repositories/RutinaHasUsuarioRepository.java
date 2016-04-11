package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Rutinahasusuario;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface RutinaHasUsuarioRepository extends CrudRepository<Rutinahasusuario, Integer>  {	
	List<Rutinahasusuario> findAll();
    List<Rutinahasusuario>  findByDiaSemanalAgendadoAndUsuario(String dia, Usuario usuario);
    List<Rutinahasusuario>  findByUsuario(Usuario usuario);
}
