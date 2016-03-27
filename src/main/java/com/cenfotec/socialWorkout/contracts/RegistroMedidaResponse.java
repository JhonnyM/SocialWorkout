package com.cenfotec.socialWorkout.contracts;
import java.util.List;

import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;

public class RegistroMedidaResponse extends BaseResponse {

	private List<RegistroMedidaPOJO> registroMedidaPOJO;

	private RegistroMedidaResponse(){
		super();
	}

	public List<RegistroMedidaPOJO> getRegistroMedidaPOJO() {
		return registroMedidaPOJO;
	}


	public void setRegistroMedidaPOJO(List<RegistroMedidaPOJO> registroMedidaPOJO) {
		this.registroMedidaPOJO = registroMedidaPOJO;
	}

	
}

