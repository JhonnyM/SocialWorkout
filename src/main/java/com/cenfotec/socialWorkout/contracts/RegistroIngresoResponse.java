package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.RegistroIngresoPOJO;

public class RegistroIngresoResponse extends BaseResponse{
	
	List<RegistroIngresoPOJO> registroIngreso;

	public List<RegistroIngresoPOJO> getRegistroIngreso() {
		return registroIngreso;
	}

	public void setRegistroIngreso(List<RegistroIngresoPOJO> registroIngreso) {
		this.registroIngreso = registroIngreso;
	}
	
	
	
	

}
