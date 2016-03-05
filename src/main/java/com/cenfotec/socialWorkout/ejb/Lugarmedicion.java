package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lugarmedicion database table.
 * 
 */
@Entity
@NamedQuery(name="Lugarmedicion.findAll", query="SELECT l FROM Lugarmedicion l")
public class Lugarmedicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLugarMedicion;

	private String descLugarMedicion;

	//bi-directional many-to-one association to Unidadmedida
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUnidadMedida")
	private Unidadmedida unidadmedida;

	//bi-directional many-to-one association to Registromedida
	@OneToMany(mappedBy="lugarmedicion")
	private List<Registromedida> registromedidas;

	public Lugarmedicion() {
	}

	public int getIdLugarMedicion() {
		return this.idLugarMedicion;
	}

	public void setIdLugarMedicion(int idLugarMedicion) {
		this.idLugarMedicion = idLugarMedicion;
	}

	public String getDescLugarMedicion() {
		return this.descLugarMedicion;
	}

	public void setDescLugarMedicion(String descLugarMedicion) {
		this.descLugarMedicion = descLugarMedicion;
	}

	public Unidadmedida getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(Unidadmedida unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public List<Registromedida> getRegistromedidas() {
		return this.registromedidas;
	}

	public void setRegistromedidas(List<Registromedida> registromedidas) {
		this.registromedidas = registromedidas;
	}

	public Registromedida addRegistromedida(Registromedida registromedida) {
		getRegistromedidas().add(registromedida);
		registromedida.setLugarmedicion(this);

		return registromedida;
	}

	public Registromedida removeRegistromedida(Registromedida registromedida) {
		getRegistromedidas().remove(registromedida);
		registromedida.setLugarmedicion(null);

		return registromedida;
	}

}