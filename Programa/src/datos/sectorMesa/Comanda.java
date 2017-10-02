package datos.sectorMesa;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import negocio.Funciones;

public class Comanda {
	private int idComanda;
	private OcupacionMesa ocupacionMesa;
	private GregorianCalendar fechaHora;
	private Set<DetalleComanda> detalleComandas;
	private boolean anulada;
	
	public Comanda() {
	
	}
	
	public Comanda(OcupacionMesa ocupacionMesa) {
		super();
		this.ocupacionMesa = ocupacionMesa;
		fechaHora = new GregorianCalendar();
		anulada = false;
	}
	
	public int getIdComanda() {
		return idComanda;
	}
	protected void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	public OcupacionMesa getOcupacionMesa() {
		return ocupacionMesa;
	}
	public void setOcupacionMesa(OcupacionMesa ocupacionMesa) {
		this.ocupacionMesa = ocupacionMesa;
	}
	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}
	public boolean getAnulada() {
		return anulada;
	}
	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}
	
	public Set<DetalleComanda> getDetalleComandas() {
		return detalleComandas;
	}

	public void setDetalleComandas(Set<DetalleComanda> detalleComandas) {
		this.detalleComandas = detalleComandas;
	}
	
	public void cargarDetalleComanda(DetalleComanda detalleComanda){
		if (detalleComandas == null) {
			detalleComandas = new HashSet<DetalleComanda>();
		}
		detalleComandas.add(detalleComanda);
	}
	
	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", fechaHora=" + Funciones.traerFechaCorta(fechaHora)
				+ ", anulada=" + anulada + "]";
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
