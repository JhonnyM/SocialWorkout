package com.cenfotec.socialWorkout.repositories;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface UserRepository  extends CrudRepository<Usuario,Integer>{
	
	Usuario findBycorreoElectronico(String email,String password);
	List<Usuario> findAll();
	List<Usuario> findBynombreContaining(String name);

}
