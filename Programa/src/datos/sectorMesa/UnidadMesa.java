package datos.sectorMesa;

public class UnidadMesa {
	private int idUnidadMesa;
	private Mesa mesa;
	private int nroMesa;
	private int cantidadComensales;
	
	public UnidadMesa(){}

	public UnidadMesa(Mesa mesa, int nroMesa, int cantidadComensales) {
		super();
		this.mesa = mesa;
		this.nroMesa = nroMesa;
		this.cantidadComensales = cantidadComensales;
	}

	public int getIdUnidadMesa() {
		return idUnidadMesa;
	}

	protected void setIdUnidadMesa(int idUnidadMesa) {
		this.idUnidadMesa = idUnidadMesa;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	@Override
	public String toString() {
		return "UnidadMesa [idUnidadMesa=" + idUnidadMesa + ", mesa=" + mesa
				+ ", nroMesa=" + nroMesa + ", cantidadComensales="
				+ cantidadComensales + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUnidadMesa;
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
		UnidadMesa other = (UnidadMesa) obj;
		if (idUnidadMesa != other.idUnidadMesa)
			return false;
		return true;
	}
 
}
