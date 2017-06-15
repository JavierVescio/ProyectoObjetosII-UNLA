package datos.sectorMesa;
import datos.sectorProducto.*;

public class DetalleComanda {
	private int idDetalleComanda;
	private Comanda comanda;
	private Producto producto;
	private int		cantidad;
	private float	precio;
	private boolean	anulada;
	
	public DetalleComanda() {
		
	}
	
	public DetalleComanda(Comanda comanda, Producto producto, int cantidad,
			float precio, boolean anulada) {
		super();
		this.comanda = comanda;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.anulada = anulada;
	}

	public int getIdDetalleComanda() {
		return idDetalleComanda;
	}
	protected void setIdDetalleComanda(int idDetalleComanda) {
		this.idDetalleComanda = idDetalleComanda;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isAnulada() {
		return anulada;
	}
	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}

	@Override
	public String toString() {
		return "DetalleComanda [idDetalleComanda=" + idDetalleComanda
				+ ", comanda=" + comanda + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precio=" + precio
				+ ", anulada=" + anulada + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDetalleComanda;
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
		DetalleComanda other = (DetalleComanda) obj;
		if (idDetalleComanda != other.idDetalleComanda)
			return false;
		return true;
	}

	
	
	
	
}
