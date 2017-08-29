package datos.sectorPersonal;

public class LogIn {
	private int idLogIn;
	private String usuario;
	private String contrasenia;
	private boolean enLinea;
	
	public LogIn(){}

	public LogIn(String usuario, String contrasenia, boolean enLinea) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.enLinea = enLinea;
	}

	public int getIdLogIn() {
		return idLogIn;
	}

	protected void setIdLogIn(int idLogIn) {
		this.idLogIn = idLogIn;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean getEnLinea() {
		return enLinea;
	}

	public void setEnLinea(boolean enLinea) {
		this.enLinea = enLinea;
	}

	@Override
	public String toString() {
		return "LogIn [idLogin=" + idLogIn + ", usuario=" + usuario
				+ ", contrasenia=" + contrasenia + ", enLinea=" + enLinea + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLogIn;
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
		LogIn other = (LogIn) obj;
		if (idLogIn != other.idLogIn)
			return false;
		return true;
	}
}
