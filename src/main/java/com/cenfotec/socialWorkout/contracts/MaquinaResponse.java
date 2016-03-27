package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;

public class MaquinaResponse extends BaseResponse {

	public List<MaquinaPOJO> maquinas;
	
	public MaquinaResponse(){
		super();
	}
	
	public List<MaquinaPOJO> getMaquinas(){
		return maquinas;
	}
	
	public void setMaquinas(List<MaquinaPOJO> maquinas){
		this.maquinas = maquinas;
	}
	
}
