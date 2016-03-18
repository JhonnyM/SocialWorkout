package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public class MaquinahasejercicioResponse extends BaseResponse {


	public List<MaquinahasejercicioPOJO> maquinasEjercicios;
	
	public MaquinahasejercicioResponse(){
		super();
	}
	
	public List<MaquinahasejercicioPOJO> getMaquinasEjercicios(){
		return maquinasEjercicios;
	}
	
	public void setMaquinasEjercicios(List<MaquinahasejercicioPOJO> maquinasEjercicios){
		this.maquinasEjercicios = maquinasEjercicios;
	}
	
	
}
