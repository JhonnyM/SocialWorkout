package com.cenfotec.socialWorkout.services;

import java.util.List;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public interface UnidadMedidaServiceInterface {

	List<UnidadmedidaPOJO> getAll(UnidadMedidaRequest umr);

	List<UnidadmedidaPOJO> getAllByDescUnidadMedida(UnidadMedidaRequest umr);

	Unidadmedida getAllByIdUnidadMedida(Unidadmedida um);

	Boolean saveUnidadMedida(Unidadmedida um);

	Boolean editUnidadMedida(Unidadmedida um);

	public boolean delete(int idObj);

	public boolean exists(Integer idObj);

}
