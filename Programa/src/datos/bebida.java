package datos;

public class Bebida extends Producto{
	private int idBebida;
	private String notas;
	
	public Bebida(){}
	
	public Bebida(String nombre, String descripcion, String imagen, String notas) {
		super(nombre,descripcion,imagen);
		this.notas = notas;
	}
	
	public int getIdBebida() {
		return idBebida;
	}

	protected void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Bebida [idBebida=" + idBebida + ", notas=" + notas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idBebida;
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
		Bebida other = (Bebida) obj;
		if (idBebida != other.idBebida)
			return false;
		return true;
	}
	
}
