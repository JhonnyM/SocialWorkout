package com.cenfotec.socialWorkout.ejb;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventoshasusuarios database table.
 * 
 */
@Entity
@Table(name="eventoshasusuarios")
@NamedQuery(name="Eventoshasusuario.findAll", query="SELECT e FROM Eventoshasusuario e")
public class Eventoshasusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEventoHasUsuario;

	//bi-directional many-to-one association to Evento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEvento")
	private Evento evento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Eventoshasusuario() {
	}

	public int getIdEventoHasUsuario() {
		return this.idEventoHasUsuario;
	}

	public void setIdEventoHasUsuario(int idEventoHasUsuario) {
		this.idEventoHasUsuario = idEventoHasUsuario;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}