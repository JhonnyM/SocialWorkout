package com.cenfotec.socialWorkout.services;

import java.util.List;


import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.contracts.PlantillarutinamaestroRequest;

public interface PlantillarutinamaestroServiceInterface {
	List<PlantillarutinamaestroPOJO> getAll();
	public boolean exists (Integer id);
	public boolean save(PlantillarutinamaestroRequest request);
	public boolean delete(Integer idPlantilla);
	PlantillarutinamaestroPOJO getRutinaXId(int idRutina);

}
