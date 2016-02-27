package com.cenfotec.socialWorkout.services;
import java.util.List;
import com.cenfotec.socialWorkout.contracts.UnidadmedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public interface UnidadmedidaServiceInterface{
	List<UnidadmedidaPOJO> getAllByIdUnidadMedida(UnidadmedidaRequest umr);
	List<UnidadmedidaPOJO> getAll(UnidadmedidaRequest umr);
	List<UnidadmedidaPOJO> getAllByDescUnidadMedida(UnidadmedidaRequest umr);
}

