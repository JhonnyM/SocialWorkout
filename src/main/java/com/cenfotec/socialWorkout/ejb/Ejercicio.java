package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEjercicio;

	private String descEjercicio;

	//bi-directional many-to-one association to Maquinahasejercicio
	@OneToMany(mappedBy="ejercicio")
	private List<Maquinahasejercicio> maquinahasejercicios;

	public Ejercicio() {
	}

	public int getIdEjercicio() {
		return this.idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getDescEjercicio() {
		return this.descEjercicio;
	}

	public void setDescEjercicio(String descEjercicio) {
		this.descEjercicio = descEjercicio;
	}

	public List<Maquinahasejercicio> getMaquinahasejercicios() {
		return this.maquinahasejercicios;
	}

	public void setMaquinahasejercicios(List<Maquinahasejercicio> maquinahasejercicios) {
		this.maquinahasejercicios = maquinahasejercicios;
	}

	public Maquinahasejercicio addMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
		getMaquinahasejercicios().add(maquinahasejercicio);
		maquinahasejercicio.setEjercicio(this);

		return maquinahasejercicio;
	}

	public Maquinahasejercicio removeMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
		getMaquinahasejercicios().remove(maquinahasejercicio);
		maquinahasejercicio.setEjercicio(null);

		return maquinahasejercicio;
	}

}