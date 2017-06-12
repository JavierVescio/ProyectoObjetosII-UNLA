package datos;

public class Plato extends Producto {
	private int idPlato;
	private String notas;
	
	public Plato() {}

	public Plato(String nombre, String descripcion, String imagen, String notas) {
		super(nombre,descripcion,imagen);
		this.notas = notas;
	}

	public int getIdPlato() {
		return idPlato;
	}
	
	protected void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", notas=" + notas + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		if (idPlato != other.idPlato)
			return false;
		return true;
	}
}
