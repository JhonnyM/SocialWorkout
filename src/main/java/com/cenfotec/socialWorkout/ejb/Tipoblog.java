package com.cenfotec.socialWorkout.ejb;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoblog database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoblog.findAll", query="SELECT t FROM Tipoblog t")
public class Tipoblog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTipoBlog;

	private String descTipoBlog;

	//bi-directional many-to-one association to Registroblog
	@OneToMany(mappedBy="tipoblog")
	private List<Registroblog> registroblogs;

	public Tipoblog() {
	}

	public int getIdTipoBlog() {
		return this.idTipoBlog;
	}

	public void setIdTipoBlog(int idTipoBlog) {
		this.idTipoBlog = idTipoBlog;
	}

	public String getDescTipoBlog() {
		return this.descTipoBlog;
	}

	public void setDescTipoBlog(String descTipoBlog) {
		this.descTipoBlog = descTipoBlog;
	}

	public List<Registroblog> getRegistroblogs() {
		return this.registroblogs;
	}

	public void setRegistroblogs(List<Registroblog> registroblogs) {
		this.registroblogs = registroblogs;
	}

	public Registroblog addRegistroblog(Registroblog registroblog) {
		getRegistroblogs().add(registroblog);
		registroblog.setTipoblog(this);

		return registroblog;
	}

	public Registroblog removeRegistroblog(Registroblog registroblog) {
		getRegistroblogs().remove(registroblog);
		registroblog.setTipoblog(null);

		return registroblog;
	}

}