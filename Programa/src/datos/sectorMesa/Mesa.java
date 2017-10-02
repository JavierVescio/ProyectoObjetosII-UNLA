package datos.sectorMesa;
import java.util.HashSet;
import java.util.Set;

public class Mesa {
	private int idMesa;
	private int nroMesa;
	private int estado;	//'0', '1' ('libre', 'ocupada') respectivamente.
	private Set<UnidadMesa> unidades;
	
	public Mesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mesa(int nroMesa, int estado) {
		super();
		this.nroMesa = nroMesa;
		this.estado = estado;
	}

	public int getIdMesa() {
		return idMesa;
	}

	protected void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Set<UnidadMesa> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<UnidadMesa> unidades) {
		this.unidades = unidades;
	}
	
	public void cargarUnidadMesa(UnidadMesa unidadMesa){
		if (unidades == null) {
			unidades = new HashSet<UnidadMesa>();
		}
		unidades.add(unidadMesa);
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", nroMesa=" + nroMesa + ", estado="
				+ estado + ", unidades=" + unidades + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMesa;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (idMesa != other.idMesa)
			return false;
		return true;
	}
	
}
