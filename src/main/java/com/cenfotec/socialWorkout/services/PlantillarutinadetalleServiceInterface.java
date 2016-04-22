package com.cenfotec.socialWorkout.services;

import java.util.List;


import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;
import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleRequest;

public interface PlantillarutinadetalleServiceInterface {
	List<PlantillarutinadetallePOJO> getAll();
	public boolean exists (Integer id);
	public boolean save(PlantillarutinadetalleRequest request);
	public boolean delete(Integer idPlantilla);
	List<PlantillarutinadetallePOJO> getPlantillaRutinaDetalleXIdRutina(int idRutina);
}
