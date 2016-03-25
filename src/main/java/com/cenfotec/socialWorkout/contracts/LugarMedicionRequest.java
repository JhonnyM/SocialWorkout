package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;

public class LugarMedicionRequest extends BaseRequest {
	
	private LugarMedicionPOJO lugarMedicion;
		
		public LugarMedicionRequest() {
			super();
		}
		
		public LugarMedicionPOJO getLugarMedicion() {
			return lugarMedicion;
		}
		
		public void setLugarMedicion(LugarMedicionPOJO lugarMedicion) {
			this.lugarMedicion = lugarMedicion;
		}
	
		@Override
		public String toString() {
			return "LugarMedicionRequest [lugarMedicion=" + lugarMedicion + "]";
		}

}
