package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;

public class TipoUsuarioRequest extends BaseRequest{
	
	private TipoUsuarioPOJO tipo;

	public TipoUsuarioRequest() {
		super();
	}
	public TipoUsuarioPOJO getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuarioPOJO tipo) {
		this.tipo = tipo;
	}
	
	
	
}
