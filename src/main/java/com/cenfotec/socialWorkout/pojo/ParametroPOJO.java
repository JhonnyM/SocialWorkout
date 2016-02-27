package com.cenfotec.socialWorkout.pojo;

public class ParametroPOJO {
	
	private int idRegistroParametro;
	private int cantidadDiasCalculoPromedios;
	private String nombreNegocio;
	
	public ParametroPOJO(){
		super();
	}
	
	public int getIdRegistroParametro() {
		return idRegistroParametro;
	}
	public void setIdRegistroParametro(int idRegistroParametro) {
		this.idRegistroParametro = idRegistroParametro;
	}
	public int getCantidadDiasCalculoPromedios() {
		return cantidadDiasCalculoPromedios;
	}
	public void setCantidadDiasCalculoPromedios(int cantidadDiasCalculoPromedios) {
		this.cantidadDiasCalculoPromedios = cantidadDiasCalculoPromedios;
	}
	public String getNombreNegocio() {
		return nombreNegocio;
	}
	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	
	

}
