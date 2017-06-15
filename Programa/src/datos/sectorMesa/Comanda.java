package datos.sectorMesa;

import java.util.GregorianCalendar;

public class Comanda {
	private int idComanda;
	private Mesa mesa;
	private GregorianCalendar fechaHora;
	private boolean anulada;
	
	public Comanda() {
	
	}
	public Comanda(Mesa mesa, GregorianCalendar fechaHora, boolean anulada) {
		super();
		this.mesa = mesa;
		this.fechaHora = fechaHora;
		this.anulada = anulada;
	}
	public int getIdComanda() {
		return idComanda;
	}
	protected void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}
	public boolean isAnulada() {
		return anulada;
	}
	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}
	
	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", mesa=" + mesa
				+ ", fechaHora=" + fechaHora + ", anulada=" + anulada + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComanda;
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
		Comanda other = (Comanda) obj;
		if (idComanda != other.idComanda)
			return false;
		return true;
	}
	
}
