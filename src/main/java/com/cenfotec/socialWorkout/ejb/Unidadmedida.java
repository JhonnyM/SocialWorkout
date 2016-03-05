package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidadmedida database table.
 * 
 */
@Entity
@NamedQuery(name="Unidadmedida.findAll", query="SELECT u FROM Unidadmedida u")
public class Unidadmedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUnidadMedida;

	private String descUnidadMedida;

	//bi-directional many-to-one association to Lugarmedicion
	@OneToMany(mappedBy="unidadmedida")
	private List<Lugarmedicion> lugarmedicions;

	public Unidadmedida() {
	}

	public int getIdUnidadMedida() {
		return this.idUnidadMedida;
	}

	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getDescUnidadMedida() {
		return this.descUnidadMedida;
	}

	public void setDescUnidadMedida(String descUnidadMedida) {
		this.descUnidadMedida = descUnidadMedida;
	}

	public List<Lugarmedicion> getLugarmedicions() {
		return this.lugarmedicions;
	}

	public void setLugarmedicions(List<Lugarmedicion> lugarmedicions) {
		this.lugarmedicions = lugarmedicions;
	}

	public Lugarmedicion addLugarmedicion(Lugarmedicion lugarmedicion) {
		getLugarmedicions().add(lugarmedicion);
		lugarmedicion.setUnidadmedida(this);

		return lugarmedicion;
	}

	public Lugarmedicion removeLugarmedicion(Lugarmedicion lugarmedicion) {
		getLugarmedicions().remove(lugarmedicion);
		lugarmedicion.setUnidadmedida(null);

		return lugarmedicion;
	}

}