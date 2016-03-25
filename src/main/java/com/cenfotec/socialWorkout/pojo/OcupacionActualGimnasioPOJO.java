package com.cenfotec.socialWorkout.pojo;
import java.math.BigInteger;

public class OcupacionActualGimnasioPOJO {

	private BigInteger id;
   private BigInteger ocupacionGimnasio;
   private BigInteger capacidad;
	
	public OcupacionActualGimnasioPOJO() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getOcupacionGimnasio() {
		return ocupacionGimnasio;
	}

	public void setOcupacionGimnasio(BigInteger ocupacionGimnasio) {
		this.ocupacionGimnasio = ocupacionGimnasio;
	}

	public BigInteger getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(BigInteger capacidad) {
		this.capacidad = capacidad;
	}
	

	
}
