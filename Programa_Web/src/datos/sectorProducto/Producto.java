package datos.sectorProducto;

import java.util.Set;

public abstract class Producto {
	//Van a ser protected asi pueden ser accedidos desde Plato/Bebida sin tener que usar los setters y getters.
	protected int idProducto; 
	protected String nombre;
	protected String descripcion;
	protected String imagen;
	protected boolean habilitado;
	protected Set<PrecioProducto> preciosProducto;
	
	public Producto() {}

	public Producto(String nombre, String descripcion, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		habilitado = true;
	}

	public int getIdProducto() {
		return idProducto;
	}
	
	protected void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Set<PrecioProducto> getPreciosProducto() {
		return preciosProducto;
	}

	public void setPreciosProducto(Set<PrecioProducto> preciosProducto) {
		this.preciosProducto = preciosProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", habilitado=" + habilitado + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
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
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	
}
