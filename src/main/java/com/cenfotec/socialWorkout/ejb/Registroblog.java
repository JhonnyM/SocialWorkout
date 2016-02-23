package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the registroblog database table.
 * 
 */
@Entity
@NamedQuery(name="Registroblog.findAll", query="SELECT r FROM Registroblog r")
public class Registroblog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroComentario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;

	//bi-directional many-to-one association to Tipoblog
	@ManyToOne
	@JoinColumn(name="idTipoBlog")
	private Tipoblog tipoblog;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	//bi-directional many-to-many association to Registroreferencia
	@ManyToMany(mappedBy="registroblogs")
	private List<Registroreferencia> registroreferencias;

	public Registroblog() {
	}

	public int getIdRegistroComentario() {
		return this.idRegistroComentario;
	}

	public void setIdRegistroComentario(int idRegistroComentario) {
		this.idRegistroComentario = idRegistroComentario;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Tipoblog getTipoblog() {
		return this.tipoblog;
	}

	public void setTipoblog(Tipoblog tipoblog) {
		this.tipoblog = tipoblog;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Registroreferencia> getRegistroreferencias() {
		return this.registroreferencias;
	}

	public void setRegistroreferencias(List<Registroreferencia> registroreferencias) {
		this.registroreferencias = registroreferencias;
	}

}