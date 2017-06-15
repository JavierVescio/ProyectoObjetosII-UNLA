package datos.sectorPersonal;

public class TipoDePersonal {
	private int idTipoDePersonal;
	private String tipoDePersonal;
	
	public TipoDePersonal() {}

	public TipoDePersonal(String tipoDePersonal) {
		super();
		this.tipoDePersonal = tipoDePersonal;
	}

	public int getIdTipoDePersonal() {
		return idTipoDePersonal;
	}

	protected void setIdTipoDePersonal(int idTipoDePersonal) {
		this.idTipoDePersonal = idTipoDePersonal;
	}

	public String getTipoDePersonal() {
		return tipoDePersonal;
	}

	public void setTipoDePersonal(String tipoDePersonal) {
		this.tipoDePersonal = tipoDePersonal;
	}

	@Override
	public String toString() {
		return "TipoDePersonal [idTipoDePersonal=" + idTipoDePersonal
				+ ", tipoDePersonal=" + tipoDePersonal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoDePersonal;
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
		TipoDePersonal other = (TipoDePersonal) obj;
		if (idTipoDePersonal != other.idTipoDePersonal)
			return false;
		return true;
	}
	
	
}
