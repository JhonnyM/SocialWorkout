package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;

public class RutinaHasUsuarioRequest extends BaseRequest {

	private RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO;
	
	public RutinaHasUsuarioRequest(){
		super();
	}
	
	public RutinaHasUsuarioPOJO getRegistroMedida(){
		return rutinaHasUsuarioPOJO;
	}
	
	public void setRegistroMedida(RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO){
		this.rutinaHasUsuarioPOJO = rutinaHasUsuarioPOJO;
	}

	@Override
	public String toString() {
		return "RutinaHasUsuarioRequest [rutinaHasUsuarioPOJO=" + rutinaHasUsuarioPOJO + "]";
	}

}
