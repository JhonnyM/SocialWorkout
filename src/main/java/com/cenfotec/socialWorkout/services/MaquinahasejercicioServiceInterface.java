package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public interface MaquinahasejercicioServiceInterface {

	public List<MaquinahasejercicioPOJO> getAll();

	public boolean save(MaquinahasejercicioRequest request);

	public boolean delete(int idTipo);

	public boolean exists(Integer idTipo);

}
