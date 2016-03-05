package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rutinahasusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Rutinahasusuario.findAll", query="SELECT r FROM Rutinahasusuario r")
public class Rutinahasusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroRutinaXUsuario;

	private String diaSemanalAgendado;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;

	//bi-directional many-to-one association to Plantillarutinamaestro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRutina")
	private Plantillarutinamaestro plantillarutinamaestro;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Rutinahasusuario() {
	}

	public int getIdRegistroRutinaXUsuario() {
		return this.idRegistroRutinaXUsuario;
	}

	public void setIdRegistroRutinaXUsuario(int idRegistroRutinaXUsuario) {
		this.idRegistroRutinaXUsuario = idRegistroRutinaXUsuario;
	}

	public String getDiaSemanalAgendado() {
		return this.diaSemanalAgendado;
	}

	public void setDiaSemanalAgendado(String diaSemanalAgendado) {
		this.diaSemanalAgendado = diaSemanalAgendado;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Plantillarutinamaestro getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}