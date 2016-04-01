package com.cenfotec.socialWorkout.utils;

public class Validations {

	public boolean validarCampoNumeroVacio(float number){
		
		String numberC = Double.toString(number);

		return numberC.matches("^\\d+$");
	}

	public boolean validarCampoTextoVacio(String text){
	
		return text.matches("[a-zA-Z]+\\.?");
	
	}
	
}
