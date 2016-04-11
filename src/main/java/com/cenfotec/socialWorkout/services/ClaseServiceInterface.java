package com.cenfotec.socialWorkout.services;

import java.util.List;


import com.cenfotec.socialWorkout.pojo.ClasePOJO;
import com.cenfotec.socialWorkout.contracts.ClaseRequest;

public interface ClaseServiceInterface {

	public List<ClasePOJO> getAll();
	public ClasePOJO getById(ClaseRequest request);
	public boolean save (ClaseRequest request);
	public boolean delete(int idTipo);
	public boolean exists (Integer idTipo);
	

}
