package datos.sectorPersonal;

public class Cliente extends Persona {
	private int idCliente;
	private TipoCliente tipoCliente;
	
	public Cliente(){}

	public Cliente(String dni, String nombre, String apellido, TipoCliente tipoCliente) {
		super(dni,nombre,apellido);
		this.tipoCliente = tipoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", nombre="
				+ nombre + ", apellido=" + apellido 
				+ "] Cliente [idCliente=" + idCliente + ", tipoCliente="
				+ tipoCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCliente;
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
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		return true;
	}
	
	
}
