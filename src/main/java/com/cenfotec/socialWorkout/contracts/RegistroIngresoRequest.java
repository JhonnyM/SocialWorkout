package com.cenfotec.socialWorkout.contracts;

import java.util.Date;

import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.ejb.Usuario;

public class RegistroIngresoRequest extends BaseRequest{
	
	private int idRegistroIngreso;
	private Date fechaHoraIngreso;
	private Date fechaHoraSalida;
	private Usuario usuario1;
	private Usuario usuario2;
	private Plantillarutinamaestro plantillarutinamaestro;
	
	public RegistroIngresoRequest(){
		super();
	}
	
	public RegistroIngresoRequest(int pidRegistroIngreso, Date pfechaHoraIngreso, Date pfechaHoraSalida,
									Usuario pusuario1, Usuario pusuario2, Plantillarutinamaestro pplantillarutinamaestro){
		super();
		idRegistroIngreso = pidRegistroIngreso;
		fechaHoraIngreso = pfechaHoraIngreso;
		fechaHoraSalida = pfechaHoraSalida;
		usuario1 = pusuario1;
		usuario2 = pusuario2;
		plantillarutinamaestro = pplantillarutinamaestro;
		
	}

	public int getIdRegistroIngreso() {
		return idRegistroIngreso;
	}

	public void setIdRegistroIngreso(int idRegistroIngreso) {
		this.idRegistroIngreso = idRegistroIngreso;
	}

	public Date getFechaIngreso() {
		return fechaHoraIngreso;
	}

	public void setFechaIngreso(Date fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public Date getFechaSalida() {
		return fechaHoraSalida;
	}

	public void setFechaSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public Plantillarutinamaestro getRutina() {
		return plantillarutinamaestro;
	}

	public void setRutina(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}
	
	

}
