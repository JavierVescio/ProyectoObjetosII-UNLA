package datos.sectorPersonal;

public class TipoPersonal {
	private int idTipoPersonal;
	private String nombre;
	
	public TipoPersonal() {}

	public TipoPersonal(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdTipoPersonal() {
		return idTipoPersonal;
	}

	protected void setIdTipoPersonal(int idTipoPersonal) {
		this.idTipoPersonal = idTipoPersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoDePersonal [idTipoPersonal=" + idTipoPersonal
				+ ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoPersonal;
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
		TipoPersonal other = (TipoPersonal) obj;
		if (idTipoPersonal != other.idTipoPersonal)
			return false;
		return true;
	}
	
	
}
