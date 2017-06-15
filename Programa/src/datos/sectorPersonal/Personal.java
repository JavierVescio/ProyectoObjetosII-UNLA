package datos.sectorPersonal;

public class Personal extends Persona{
	private int idPersonal;
	private Login login;
	private TipoDePersonal tipoDePersonal;
	private String cuil;
	
	public Personal() {}

	public Personal(String dni, String nombre, String apellido, Login login, TipoDePersonal tipoDePersonal,
			String cuil) {
		super(dni,nombre,apellido);
		this.login = login;
		this.tipoDePersonal = tipoDePersonal;
		this.cuil = cuil;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	protected void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public TipoDePersonal getTipoDePersonal() {
		return tipoDePersonal;
	}

	public void setTipoDePersonal(TipoDePersonal tipoDePersonal) {
		this.tipoDePersonal = tipoDePersonal;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", login=" + login
				+ ", tipoDePersonal=" + tipoDePersonal + ", cuil=" + cuil + "]";
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
