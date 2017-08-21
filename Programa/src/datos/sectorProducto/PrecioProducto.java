package datos.sectorProducto;

import java.util.GregorianCalendar;

import datos.sectorPersonal.TipoCliente;

public class PrecioProducto {
	private int idPrecioProducto;
	private double precio;
	private GregorianCalendar fechaCreacion;
	private Producto producto;
	private TipoCliente tipoCliente;
	
	public PrecioProducto() {}

	public PrecioProducto(double precio, GregorianCalendar fechaCreacion, Producto producto) {
		super();
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.producto = producto;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public GregorianCalendar getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(GregorianCalendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdPrecioProducto() {
		return idPrecioProducto;
	}

	public void setIdPrecioProducto(int idPrecioProducto) {
		this.idPrecioProducto = idPrecioProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	@Override
	public String toString() {
		return "PrecioProducto [idPrecioProducto=" + idPrecioProducto
				+ ", precio=" + precio + ", fechaCreacion=" + fechaCreacion
				+ ", producto=" + producto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrecioProducto;
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
		PrecioProducto other = (PrecioProducto) obj;
		if (idPrecioProducto != other.idPrecioProducto)
			return false;
		return true;
	}
	
}
