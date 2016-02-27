package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public class UnidadmedidaRequest {

	private UnidadmedidaPOJO unidadMedida;
	
	public UnidadmedidaRequest(){
		super();
	}
	
	public UnidadmedidaPOJO getUnidadMedida(){
		return unidadMedida;
	}
	
	public void setUnidadMedida(UnidadmedidaPOJO unidadMedida){
		this.unidadMedida = unidadMedida;
	}
	
	public String toString() {
		return "UnidadMedidaRequest [unidadMedida=" + unidadMedida + "]";
	}
	
}
