package com.cenfotec.socialWorkout.repositories;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UnidadMedidaRepository extends CrudRepository<Unidadmedida,Integer>{
	List<Unidadmedida> findAll();
	Unidadmedida findByIdUnidadMedida(int idUnidadMedida);
}
