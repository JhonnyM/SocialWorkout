package com.cenfotec.socialWorkout.services;
import java.util.List;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public interface UnidadMedidaServiceInterface{
	List<UnidadmedidaPOJO> getAllByIdUnidadMedida(UnidadMedidaRequest umr);
	List<UnidadmedidaPOJO> getAll(UnidadMedidaRequest umr);
	List<UnidadmedidaPOJO> getAllByDescUnidadMedida(UnidadMedidaRequest umr);
	Boolean saveUnidadMedida(Unidadmedida um);
}

