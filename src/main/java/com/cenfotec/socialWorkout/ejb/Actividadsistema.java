package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actividadsistema database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadsistema.findAll", query="SELECT a FROM Actividadsistema a")
public class Actividadsistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idActividadSistema;

	private String descActividadSistema;

	//bi-directional many-to-one association to Tipoactividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTipoActividad")
	private Tipoactividad tipoactividad;

	//bi-directional many-to-one association to Actividadsistemahasusuario
	@OneToMany(mappedBy="actividadsistema")
	private List<Actividadsistemahasusuario> actividadsistemahasusuarios;

	public Actividadsistema() {
	}

	public int getIdActividadSistema() {
		return this.idActividadSistema;
	}

	public void setIdActividadSistema(int idActividadSistema) {
		this.idActividadSistema = idActividadSistema;
	}

	public String getDescActividadSistema() {
		return this.descActividadSistema;
	}

	public void setDescActividadSistema(String descActividadSistema) {
		this.descActividadSistema = descActividadSistema;
	}

	public Tipoactividad getTipoactividad() {
		return this.tipoactividad;
	}

	public void setTipoactividad(Tipoactividad tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

	public List<Actividadsistemahasusuario> getActividadsistemahasusuarios() {
		return this.actividadsistemahasusuarios;
	}

	public void setActividadsistemahasusuarios(List<Actividadsistemahasusuario> actividadsistemahasusuarios) {
		this.actividadsistemahasusuarios = actividadsistemahasusuarios;
	}

	public Actividadsistemahasusuario addActividadsistemahasusuario(Actividadsistemahasusuario actividadsistemahasusuario) {
		getActividadsistemahasusuarios().add(actividadsistemahasusuario);
		actividadsistemahasusuario.setActividadsistema(this);

		return actividadsistemahasusuario;
	}

	public Actividadsistemahasusuario removeActividadsistemahasusuario(Actividadsistemahasusuario actividadsistemahasusuario) {
		getActividadsistemahasusuarios().remove(actividadsistemahasusuario);
		actividadsistemahasusuario.setActividadsistema(null);

		return actividadsistemahasusuario;
	}

}