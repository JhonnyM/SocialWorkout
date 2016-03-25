package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;

public class LugarMedicionResponse extends BaseResponse {
	
	private List<LugarMedicionPOJO> lugaresMedicionPOJO;
	//private LugarMedicionPOJO lugarMedicionPOJO;

	public LugarMedicionResponse() {
		super();
	}
	
	public List<LugarMedicionPOJO> getLugaresMedicion() {
		return lugaresMedicionPOJO;
	}

	public void setLugaresMedicionPOJO(List<LugarMedicionPOJO> lugaresMedicionPOJO) {
		this.lugaresMedicionPOJO = lugaresMedicionPOJO;
	}

/*	public LugarMedicionPOJO getLugarMedicionPOJO() {
		return lugarMedicionPOJO;
	}

	public void setUsuario(LugarMedicionPOJO lugarMedicionPOJO) {
		this.lugarMedicionPOJO = lugarMedicionPOJO;
	}*/

}
