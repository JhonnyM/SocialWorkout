

package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.ParametroPOJO;

public class ParametroRequest extends BaseRequest{
	
	private int idRegistroParametro;
	private int cantidadDiasCalculoPromedios;
	private String nombreNegocio;
	private ParametroPOJO parametro;
	
	
	public ParametroRequest(){
		super();
	}
	
	public ParametroRequest(String pnombre, int pcantidad){
		super();
		cantidadDiasCalculoPromedios = pcantidad;
		nombreNegocio = pnombre;
		
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

	public ParametroPOJO getParametro() {
		return parametro;
	}

	public void setParametro(ParametroPOJO parametro) {
		this.parametro = parametro;
	}
}