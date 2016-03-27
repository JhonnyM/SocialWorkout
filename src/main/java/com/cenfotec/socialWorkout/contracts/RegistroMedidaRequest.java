package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;

public class RegistroMedidaRequest extends BaseRequest {

	private RegistroMedidaPOJO registroMedida;
	
	public RegistroMedidaRequest(){
		super();
	}
	
	public RegistroMedidaPOJO getRegistroMedida(){
		return registroMedida;
	}
	
	public void setRegistroMedida(RegistroMedidaPOJO registroMedida){
		this.registroMedida = registroMedida;
	}

	@Override
	public String toString() {
		return "RegistroMedidaRequest [registroMedida=" + registroMedida + "]";
	}

	
}
