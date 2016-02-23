package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuario;

	private String apellidos;

	private String clave;

	private String correoElectronico;

	private byte estatus;

	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

	@Temporal(TemporalType.DATE)
	private Date fechaNac;

	@Temporal(TemporalType.DATE)
	private Date fechaPago;

	private String identificacion;

	private String nombre;

	private boolean poseeVehiculo;

	//bi-directional many-to-one association to Actividadsistemahastipousuario
	@OneToMany(mappedBy="usuario")
	private List<Actividadsistemahastipousuario> actividadsistemahastipousuarios;

	//bi-directional many-to-one association to Entrenamientopersonalizado
	@OneToMany(mappedBy="usuario1")
	private List<Entrenamientopersonalizado> entrenamientopersonalizados1;

	//bi-directional many-to-one association to Entrenamientopersonalizado
	@OneToMany(mappedBy="usuario2")
	private List<Entrenamientopersonalizado> entrenamientopersonalizados2;

	//bi-directional many-to-many association to Evento
	@ManyToMany
	@JoinTable(
		name="eventoshasusuarios"
		, joinColumns={
			@JoinColumn(name="idUsuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idEvento")
			}
		)
	private List<Evento> eventos;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario1")
	private List<Mensaje> mensajes1;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario2")
	private List<Mensaje> mensajes2;

	//bi-directional many-to-one association to Rankeo
	@OneToMany(mappedBy="usuario1")
	private List<Rankeo> rankeos1;

	//bi-directional many-to-one association to Rankeo
	@OneToMany(mappedBy="usuario2")
	private List<Rankeo> rankeos2;

	//bi-directional many-to-one association to Registroblog
	@OneToMany(mappedBy="usuario")
	private List<Registroblog> registroblogs;

	//bi-directional many-to-one association to Registroingreso
	@OneToMany(mappedBy="usuario1")
	private List<Registroingreso> registroingresos1;

	//bi-directional many-to-one association to Registroingreso
	@OneToMany(mappedBy="usuario2")
	private List<Registroingreso> registroingresos2;

	//bi-directional many-to-one association to Registromedida
	@OneToMany(mappedBy="usuario")
	private List<Registromedida> registromedidas;

	//bi-directional many-to-one association to Registroplanclas
	@OneToMany(mappedBy="usuario")
	private List<Registroplanclas> registroplanclases;

	//bi-directional many-to-one association to Rutinahasusuario
	@OneToMany(mappedBy="usuario")
	private List<Rutinahasusuario> rutinahasusuarios;

	//bi-directional many-to-one association to Tipousuario
	@ManyToOne
	@JoinColumn(name="idTipoUsuario")
	private Tipousuario tipousuario;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioInstructor")
	private Usuario usuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="usuario")
	private List<Usuario> usuarios;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public byte getEstatus() {
		return this.estatus;
	}

	public void setEstatus(byte estatus) {
		this.estatus = estatus;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getPoseeVehiculo() {
		return this.poseeVehiculo;
	}

	public void setPoseeVehiculo(boolean poseeVehiculo) {
		this.poseeVehiculo = poseeVehiculo;
	}

	public List<Actividadsistemahastipousuario> getActividadsistemahastipousuarios() {
		return this.actividadsistemahastipousuarios;
	}

	public void setActividadsistemahastipousuarios(List<Actividadsistemahastipousuario> actividadsistemahastipousuarios) {
		this.actividadsistemahastipousuarios = actividadsistemahastipousuarios;
	}

	public Actividadsistemahastipousuario addActividadsistemahastipousuario(Actividadsistemahastipousuario actividadsistemahastipousuario) {
		getActividadsistemahastipousuarios().add(actividadsistemahastipousuario);
		actividadsistemahastipousuario.setUsuario(this);

		return actividadsistemahastipousuario;
	}

	public Actividadsistemahastipousuario removeActividadsistemahastipousuario(Actividadsistemahastipousuario actividadsistemahastipousuario) {
		getActividadsistemahastipousuarios().remove(actividadsistemahastipousuario);
		actividadsistemahastipousuario.setUsuario(null);

		return actividadsistemahastipousuario;
	}

	public List<Entrenamientopersonalizado> getEntrenamientopersonalizados1() {
		return this.entrenamientopersonalizados1;
	}

	public void setEntrenamientopersonalizados1(List<Entrenamientopersonalizado> entrenamientopersonalizados1) {
		this.entrenamientopersonalizados1 = entrenamientopersonalizados1;
	}

	public Entrenamientopersonalizado addEntrenamientopersonalizados1(Entrenamientopersonalizado entrenamientopersonalizados1) {
		getEntrenamientopersonalizados1().add(entrenamientopersonalizados1);
		entrenamientopersonalizados1.setUsuario1(this);

		return entrenamientopersonalizados1;
	}

	public Entrenamientopersonalizado removeEntrenamientopersonalizados1(Entrenamientopersonalizado entrenamientopersonalizados1) {
		getEntrenamientopersonalizados1().remove(entrenamientopersonalizados1);
		entrenamientopersonalizados1.setUsuario1(null);

		return entrenamientopersonalizados1;
	}

	public List<Entrenamientopersonalizado> getEntrenamientopersonalizados2() {
		return this.entrenamientopersonalizados2;
	}

	public void setEntrenamientopersonalizados2(List<Entrenamientopersonalizado> entrenamientopersonalizados2) {
		this.entrenamientopersonalizados2 = entrenamientopersonalizados2;
	}

	public Entrenamientopersonalizado addEntrenamientopersonalizados2(Entrenamientopersonalizado entrenamientopersonalizados2) {
		getEntrenamientopersonalizados2().add(entrenamientopersonalizados2);
		entrenamientopersonalizados2.setUsuario2(this);

		return entrenamientopersonalizados2;
	}

	public Entrenamientopersonalizado removeEntrenamientopersonalizados2(Entrenamientopersonalizado entrenamientopersonalizados2) {
		getEntrenamientopersonalizados2().remove(entrenamientopersonalizados2);
		entrenamientopersonalizados2.setUsuario2(null);

		return entrenamientopersonalizados2;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Mensaje> getMensajes1() {
		return this.mensajes1;
	}

	public void setMensajes1(List<Mensaje> mensajes1) {
		this.mensajes1 = mensajes1;
	}

	public Mensaje addMensajes1(Mensaje mensajes1) {
		getMensajes1().add(mensajes1);
		mensajes1.setUsuario1(this);

		return mensajes1;
	}

	public Mensaje removeMensajes1(Mensaje mensajes1) {
		getMensajes1().remove(mensajes1);
		mensajes1.setUsuario1(null);

		return mensajes1;
	}

	public List<Mensaje> getMensajes2() {
		return this.mensajes2;
	}

	public void setMensajes2(List<Mensaje> mensajes2) {
		this.mensajes2 = mensajes2;
	}

	public Mensaje addMensajes2(Mensaje mensajes2) {
		getMensajes2().add(mensajes2);
		mensajes2.setUsuario2(this);

		return mensajes2;
	}

	public Mensaje removeMensajes2(Mensaje mensajes2) {
		getMensajes2().remove(mensajes2);
		mensajes2.setUsuario2(null);

		return mensajes2;
	}

	public List<Rankeo> getRankeos1() {
		return this.rankeos1;
	}

	public void setRankeos1(List<Rankeo> rankeos1) {
		this.rankeos1 = rankeos1;
	}

	public Rankeo addRankeos1(Rankeo rankeos1) {
		getRankeos1().add(rankeos1);
		rankeos1.setUsuario1(this);

		return rankeos1;
	}

	public Rankeo removeRankeos1(Rankeo rankeos1) {
		getRankeos1().remove(rankeos1);
		rankeos1.setUsuario1(null);

		return rankeos1;
	}

	public List<Rankeo> getRankeos2() {
		return this.rankeos2;
	}

	public void setRankeos2(List<Rankeo> rankeos2) {
		this.rankeos2 = rankeos2;
	}

	public Rankeo addRankeos2(Rankeo rankeos2) {
		getRankeos2().add(rankeos2);
		rankeos2.setUsuario2(this);

		return rankeos2;
	}

	public Rankeo removeRankeos2(Rankeo rankeos2) {
		getRankeos2().remove(rankeos2);
		rankeos2.setUsuario2(null);

		return rankeos2;
	}

	public List<Registroblog> getRegistroblogs() {
		return this.registroblogs;
	}

	public void setRegistroblogs(List<Registroblog> registroblogs) {
		this.registroblogs = registroblogs;
	}

	public Registroblog addRegistroblog(Registroblog registroblog) {
		getRegistroblogs().add(registroblog);
		registroblog.setUsuario(this);

		return registroblog;
	}

	public Registroblog removeRegistroblog(Registroblog registroblog) {
		getRegistroblogs().remove(registroblog);
		registroblog.setUsuario(null);

		return registroblog;
	}

	public List<Registroingreso> getRegistroingresos1() {
		return this.registroingresos1;
	}

	public void setRegistroingresos1(List<Registroingreso> registroingresos1) {
		this.registroingresos1 = registroingresos1;
	}

	public Registroingreso addRegistroingresos1(Registroingreso registroingresos1) {
		getRegistroingresos1().add(registroingresos1);
		registroingresos1.setUsuario1(this);

		return registroingresos1;
	}

	public Registroingreso removeRegistroingresos1(Registroingreso registroingresos1) {
		getRegistroingresos1().remove(registroingresos1);
		registroingresos1.setUsuario1(null);

		return registroingresos1;
	}

	public List<Registroingreso> getRegistroingresos2() {
		return this.registroingresos2;
	}

	public void setRegistroingresos2(List<Registroingreso> registroingresos2) {
		this.registroingresos2 = registroingresos2;
	}

	public Registroingreso addRegistroingresos2(Registroingreso registroingresos2) {
		getRegistroingresos2().add(registroingresos2);
		registroingresos2.setUsuario2(this);

		return registroingresos2;
	}

	public Registroingreso removeRegistroingresos2(Registroingreso registroingresos2) {
		getRegistroingresos2().remove(registroingresos2);
		registroingresos2.setUsuario2(null);

		return registroingresos2;
	}

	public List<Registromedida> getRegistromedidas() {
		return this.registromedidas;
	}

	public void setRegistromedidas(List<Registromedida> registromedidas) {
		this.registromedidas = registromedidas;
	}

	public Registromedida addRegistromedida(Registromedida registromedida) {
		getRegistromedidas().add(registromedida);
		registromedida.setUsuario(this);

		return registromedida;
	}

	public Registromedida removeRegistromedida(Registromedida registromedida) {
		getRegistromedidas().remove(registromedida);
		registromedida.setUsuario(null);

		return registromedida;
	}

	public List<Registroplanclas> getRegistroplanclases() {
		return this.registroplanclases;
	}

	public void setRegistroplanclases(List<Registroplanclas> registroplanclases) {
		this.registroplanclases = registroplanclases;
	}

	public Registroplanclas addRegistroplanclas(Registroplanclas registroplanclas) {
		getRegistroplanclases().add(registroplanclas);
		registroplanclas.setUsuario(this);

		return registroplanclas;
	}

	public Registroplanclas removeRegistroplanclas(Registroplanclas registroplanclas) {
		getRegistroplanclases().remove(registroplanclas);
		registroplanclas.setUsuario(null);

		return registroplanclas;
	}

	public List<Rutinahasusuario> getRutinahasusuarios() {
		return this.rutinahasusuarios;
	}

	public void setRutinahasusuarios(List<Rutinahasusuario> rutinahasusuarios) {
		this.rutinahasusuarios = rutinahasusuarios;
	}

	public Rutinahasusuario addRutinahasusuario(Rutinahasusuario rutinahasusuario) {
		getRutinahasusuarios().add(rutinahasusuario);
		rutinahasusuario.setUsuario(this);

		return rutinahasusuario;
	}

	public Rutinahasusuario removeRutinahasusuario(Rutinahasusuario rutinahasusuario) {
		getRutinahasusuarios().remove(rutinahasusuario);
		rutinahasusuario.setUsuario(null);

		return rutinahasusuario;
	}

	public Tipousuario getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Tipousuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUsuario(null);

		return usuario;
	}

}