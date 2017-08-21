package datos.sectorPersonal;

public class Personal extends Persona{
	private int idPersonal;
	private LogIn logIn;
	private TipoPersonal tipoPersonal;
	private String cuil;
	
	public Personal() {}

	public Personal(String dni, String nombre, String apellido, LogIn logIn, TipoPersonal tipoPersonal,
			String cuil) {
		super(dni,nombre,apellido);
		this.logIn = logIn;
		this.tipoPersonal = tipoPersonal;
		this.cuil = cuil;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	protected void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public LogIn getLogin() {
		return logIn;
	}

	public void setLogin(LogIn logIn) {
		this.logIn = logIn;
	}

	public TipoPersonal getTipoDePersonal() {
		return tipoPersonal;
	}

	public void setTipoDePersonal(TipoPersonal tipoDePersonal) {
		this.tipoPersonal = tipoDePersonal;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", logIn=" + logIn
				+ ", tipoDePersonal=" + tipoPersonal + ", cuil=" + cuil + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idPersonal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		if (idPersonal != other.idPersonal)
			return false;
		return true;
	}
	
	
	
}
