package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the registroreferencia database table.
 * 
 */
@Entity
@NamedQuery(name="Registroreferencia.findAll", query="SELECT r FROM Registroreferencia r")
public class Registroreferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroReferencia;

	private String referencia;

	//bi-directional many-to-many association to Registroblog
	@ManyToMany
	@JoinTable(
		name="registroreferenciahasregistoblog"
		, joinColumns={
			@JoinColumn(name="idRegistroReferencia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idRegistroComentario")
			}
		)
	private List<Registroblog> registroblogs;

	public Registroreferencia() {
	}

	public int getIdRegistroReferencia() {
		return this.idRegistroReferencia;
	}

	public void setIdRegistroReferencia(int idRegistroReferencia) {
		this.idRegistroReferencia = idRegistroReferencia;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public List<Registroblog> getRegistroblogs() {
		return this.registroblogs;
	}

	public void setRegistroblogs(List<Registroblog> registroblogs) {
		this.registroblogs = registroblogs;
	}

}