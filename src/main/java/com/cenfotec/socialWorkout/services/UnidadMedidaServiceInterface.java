package com.cenfotec.socialWorkout.services;

import java.util.List;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public interface UnidadMedidaServiceInterface {

	List<UnidadmedidaPOJO> getAll();

	UnidadmedidaPOJO getById(UnidadMedidaRequest umr);
	
	UnidadmedidaPOJO getByIdUnidad(int idUnidadMedida);

	Boolean saveUnidadMedida(UnidadMedidaRequest umr);

	public boolean delete(int idObj);

	public boolean exists(Integer idObj);

}