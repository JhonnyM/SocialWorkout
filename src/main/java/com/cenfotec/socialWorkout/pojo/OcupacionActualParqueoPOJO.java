package com.cenfotec.socialWorkout.pojo;
import java.math.BigInteger;

public class OcupacionActualParqueoPOJO {

	private BigInteger id;
   private BigInteger ocupacionParqueo;
   private BigInteger capacidad;
	
	public OcupacionActualParqueoPOJO() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getOcupacionParqueo() {
		return ocupacionParqueo;
	}

	public void setOcupacionParqueo(BigInteger ocupacionParqueo) {
		this.ocupacionParqueo = ocupacionParqueo;
	}

	public BigInteger getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(BigInteger capacidad) {
		this.capacidad = capacidad;
	}
	

	
}
