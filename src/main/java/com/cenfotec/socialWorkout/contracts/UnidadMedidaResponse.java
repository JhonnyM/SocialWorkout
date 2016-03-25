package com.cenfotec.socialWorkout.contracts;
import java.util.List;

import com.cenfotec.socialWorkout.pojo.*;

public class UnidadMedidaResponse extends BaseResponse {

	public List<UnidadmedidaPOJO> unidadesMedidas;
	
	public UnidadMedidaResponse(){
		super();
	}
	
	public List<UnidadmedidaPOJO> getUnidadesMedidas(){
		return unidadesMedidas;
	}
	
	public void setUnidadesMedidas(List<UnidadmedidaPOJO> unidadesMedidas){
		this.unidadesMedidas = unidadesMedidas;
	}
	
}
