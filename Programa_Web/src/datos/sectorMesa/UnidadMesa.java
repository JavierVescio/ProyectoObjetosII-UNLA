package datos.sectorMesa;

public class UnidadMesa {
	private int idUnidadMesa;
	private Mesa mesa;

	public UnidadMesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnidadMesa(Mesa mesa) {
		super();
		this.mesa = mesa;
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

	@Override
	public String toString() {
		return "UnidadMesa [idUnidadMesa=" + idUnidadMesa + ", mesa=" + mesa
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUnidadMesa;
		return result;
	}
	
}
