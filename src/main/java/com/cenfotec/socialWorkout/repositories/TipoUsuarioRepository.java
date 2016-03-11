package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Tipousuario;

public interface TipoUsuarioRepository extends CrudRepository<Tipousuario, Integer>  {	
	List<Tipousuario> findAll();
	Tipousuario findBydescTipoUsuario(String descTipoUsuario);
	Tipousuario findByidTipoUsuario(int idTipoUsuario);
}
