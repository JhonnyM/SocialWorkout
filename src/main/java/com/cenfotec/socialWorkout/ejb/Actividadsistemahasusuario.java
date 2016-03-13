<<<<<<< HEAD:src/main/java/com/cenfotec/socialWorkout/ejb/Actividadsistemahasusuario.java
package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadsistemahasusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadsistemahasusuario.findAll", query="SELECT a FROM Actividadsistemahasusuario a")
public class Actividadsistemahasusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idActividadXUsuario;

	//bi-directional many-to-one association to Actividadsistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idActividadSistema")
	private Actividadsistema actividadsistema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Actividadsistemahasusuario() {
	}

	public int getIdActividadXUsuario() {
		return this.idActividadXUsuario;
	}

	public void setIdActividadXUsuario(int idActividadXUsuario) {
		this.idActividadXUsuario = idActividadXUsuario;
	}

	public Actividadsistema getActividadsistema() {
		return this.actividadsistema;
	}

	public void setActividadsistema(Actividadsistema actividadsistema) {
		this.actividadsistema = actividadsistema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

=======
package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadsistemahasusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadsistemahasusuario.findAll", query="SELECT a FROM Actividadsistemahasusuario a")
public class Actividadsistemahasusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idActividadXUsuario;

	//bi-directional many-to-one association to Actividadsistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idActividadSistema")
	private Actividadsistema actividadsistema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Actividadsistemahasusuario() {
	}

	public int getIdActividadXUsuario() {
		return this.idActividadXUsuario;
	}

	public void setIdActividadXUsuario(int idActividadXUsuario) {
		this.idActividadXUsuario = idActividadXUsuario;
	}

	public Actividadsistema getActividadsistema() {
		return this.actividadsistema;
	}

	public void setActividadsistema(Actividadsistema actividadsistema) {
		this.actividadsistema = actividadsistema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

>>>>>>> bb85c0b00db04ac7179a8a801ddeda2b4c5f9e0e:src/main/java/com/cenfotec/socialWorkout/ejb/Actividadsistemahasusuario.java
}