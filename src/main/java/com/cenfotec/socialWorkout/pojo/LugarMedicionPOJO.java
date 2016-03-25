package com.cenfotec.socialWorkout.pojo;

public class LugarMedicionPOJO {

	private int idLugarMedicion;
	private String descLugarMedicion;
	private UnidadmedidaPOJO unidadMedidaPOJO;
	
	public LugarMedicionPOJO() {
		super();
	}

	public int getIdLugarMedicion() {
		return idLugarMedicion;
	}

	public void setIdLugarMedicion(int idLugarMedicion) {
		this.idLugarMedicion = idLugarMedicion;
	}

	public String getDescLugarMedicion() {
		return descLugarMedicion;
	}

	public void setDescLugarMedicion(String descLugarMedicion) {
		this.descLugarMedicion = descLugarMedicion;
	}

	public UnidadmedidaPOJO getUnidadMedidaPOJO() {
		return unidadMedidaPOJO;
	}

	public void setUnidadMedidaPOJO(UnidadmedidaPOJO unidadMedidaPOJO) {
		this.unidadMedidaPOJO = unidadMedidaPOJO;
	}


}
