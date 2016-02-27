package com.cenfotec.socialWorkout.contracts;


import java.util.List;

import com.cenfotec.socialWorkout.pojo.ParametroPOJO;


public class ParametroResponse extends BaseResponse{
	
	private List<ParametroPOJO> parametros;
	
	public ParametroResponse(){
		super();
	}

	public List<ParametroPOJO> getParametros() {
		return parametros;
	}

	public void setParametros(List<ParametroPOJO> parametros) {
		this.parametros = parametros;
	}
}
