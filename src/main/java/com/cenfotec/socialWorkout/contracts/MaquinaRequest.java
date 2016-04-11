package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;

public class MaquinaRequest extends BaseRequest {

	private MaquinaPOJO maquina;
	
	public MaquinaRequest(){
		super();
	}
	
	public MaquinaPOJO getMaquina(){
		return maquina;
	}
	
	public void setMaquina(MaquinaPOJO maquina){
		this.maquina = maquina;
	}
	
	public String toString() {
		return "UnidadMedidaRequest [unidadMedida=" + maquina + "]";
	}
	
	
}
