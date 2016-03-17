package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;

public class RegistroingresoResponse extends BaseResponse {
	
	private List<RegistroingresoPOJO> registros;
	private RegistroingresoPOJO registro;

	public RegistroingresoResponse() {
		super();
	}
	
	public List<RegistroingresoPOJO> getClases() {
		return registros;
	}

	public void setClases(List<RegistroingresoPOJO> registros) {
		this.registros = registros;
	}

	public RegistroingresoPOJO getClase() {
		return registro;
	}

	public void setClase(RegistroingresoPOJO registro) {
		this.registro = registro;
	}

}