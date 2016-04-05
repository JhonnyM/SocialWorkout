package com.cenfotec.socialWorkout.services;
import java.util.List;


import com.cenfotec.socialWorkout.contracts.LugarMedicionRequest;
import com.cenfotec.socialWorkout.ejb.Lugarmedicion;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;

public interface LugarMedicionServiceInterface {
	List<LugarMedicionPOJO> getAll();
	Lugarmedicion getLugarMedicionXId(int idLugarMedicion);
	boolean save(LugarMedicionRequest lugarMedicionRequest);
	boolean edit(LugarMedicionRequest lugarMedicionRequest);
	public boolean delete(Integer idObj);
	public boolean exists (Integer idObj);

}
