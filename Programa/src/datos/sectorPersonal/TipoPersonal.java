package datos.sectorPersonal;

public class TipoPersonal {
	private int idTipoPersonal;
	private String tipoPersonal;
	
	public TipoPersonal() {}

	public TipoPersonal(String tipoPersonal) {
		super();
		this.tipoPersonal = tipoPersonal;
	}

	public int getIdTipoPersonal() {
		return idTipoPersonal;
	}

	protected void setIdTipoPersonal(int idTipoPersonal) {
		this.idTipoPersonal = idTipoPersonal;
	}

	public String getTipoPersonal() {
		return tipoPersonal;
	}

	public void setTipoPersonal(String tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}

	@Override
	public String toString() {
		return "TipoDePersonal [idTipoPersonal=" + idTipoPersonal
				+ ", tipoPersonal=" + tipoPersonal + "]";
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
