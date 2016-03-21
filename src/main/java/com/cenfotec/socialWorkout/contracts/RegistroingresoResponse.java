package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;

public class RegistroingresoResponse extends BaseResponse {
	
	private List<RegistroingresoPOJO> registros;
	private RegistroingresoPOJO registro;

	public RegistroingresoResponse() {
		super();
	}
	
	public List<RegistroingresoPOJO> getRegistros() {
		return registros;
	}

	public void setRegistro(List<RegistroingresoPOJO> registros) {
		this.registros = registros;
	}

	public RegistroingresoPOJO getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroingresoPOJO registro) {
		this.registro = registro;
	}

}