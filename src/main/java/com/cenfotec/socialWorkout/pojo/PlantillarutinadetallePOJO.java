package com.cenfotec.socialWorkout.pojo;


public class PlantillarutinadetallePOJO {

	private int idPLantillaRutinaDetalle;
	private double cantidadPeso;
	private int cantidadRepeticiones;
	private int cantidadSeries;

	private MaquinahasejercicioPOJO maquinahasejercicio;

	private PlantillarutinamaestroPOJO plantillarutinamaestro;

	public PlantillarutinadetallePOJO() {
	}

	public int getIdPLantillaRutinaDetalle() {
		return this.idPLantillaRutinaDetalle;
	}

	public void setIdPLantillaRutinaDetalle(int idPLantillaRutinaDetalle) {
		this.idPLantillaRutinaDetalle = idPLantillaRutinaDetalle;
	}

	public double getCantidadPeso() {
		return this.cantidadPeso;
	}

	public void setCantidadPeso(double cantidadPeso) {
		this.cantidadPeso = cantidadPeso;
	}

	public int getCantidadRepeticiones() {
		return this.cantidadRepeticiones;
	}

	public void setCantidadRepeticiones(int cantidadRepeticiones) {
		this.cantidadRepeticiones = cantidadRepeticiones;
	}

	public int getCantidadSeries() {
		return this.cantidadSeries;
	}

	public void setCantidadSeries(int cantidadSeries) {
		this.cantidadSeries = cantidadSeries;
	}

	public MaquinahasejercicioPOJO getMaquinahasejercicio() {
		return this.maquinahasejercicio;
	}

	public void setMaquinahasejercicio(MaquinahasejercicioPOJO maquinahasejercicio) {
		this.maquinahasejercicio = maquinahasejercicio;
	}

	public PlantillarutinamaestroPOJO getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(PlantillarutinamaestroPOJO plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

}
