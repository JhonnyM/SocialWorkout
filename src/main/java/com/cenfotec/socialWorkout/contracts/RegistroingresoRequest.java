package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;

public class RegistroingresoRequest extends BaseRequest{
	
	private RegistroingresoPOJO registro;

	public RegistroingresoRequest() {
		super();
	}
	public RegistroingresoPOJO getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroingresoPOJO registro) {
		this.registro = registro;
	}
	
	
	
}
