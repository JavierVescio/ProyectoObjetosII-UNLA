package datos.sectorMesa;

import java.util.GregorianCalendar;

import negocio.Funciones;
import datos.sectorPersonal.Cliente;
import datos.sectorPersonal.Personal;

public class OcupacionMesa {
	private int idOcupacionMesa;
	private Cliente cliente;
	private Personal camarero;
	private Mesa mesa;
	private int cantidadComensales;
	private GregorianCalendar fechaHoraInicio;
	private GregorianCalendar fechaHoraFin;
	private String habitacion;
	
	public OcupacionMesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OcupacionMesa(Cliente cliente, Personal camarero, Mesa mesa,
			int cantidadComensales, String habitacion) {
		super();
		this.cliente = cliente;
		this.camarero = camarero;
		this.mesa = mesa;
		this.cantidadComensales = cantidadComensales;
		fechaHoraInicio = new GregorianCalendar();
		fechaHoraFin = null;
		this.habitacion = habitacion;
	}

	public int getIdOcupacionMesa() {
		return idOcupacionMesa;
	}

	protected void setIdOcupacionMesa(int idOcupacionMesa) {
		this.idOcupacionMesa = idOcupacionMesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Personal getCamarero() {
		return camarero;
	}

	public void setCamarero(Personal camarero) {
		this.camarero = camarero;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public GregorianCalendar getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(GregorianCalendar fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public GregorianCalendar getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(GregorianCalendar fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOcupacionMesa;
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
		OcupacionMesa other = (OcupacionMesa) obj;
		if (idOcupacionMesa != other.idOcupacionMesa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OcupacionMesa [idOcupacionMesa=" + idOcupacionMesa
				+ ", cliente=" + cliente + ", camarero=" + camarero + ", mesa="
				+ mesa + ", cantidadComensales=" + cantidadComensales
				+ ", fechaHoraInicio=" + Funciones.traerFechaCorta(fechaHoraInicio) + ", fechaHoraFin="
				+ Funciones.traerFechaCorta(fechaHoraFin) + ", habitacion=" + habitacion + "]";
	}
	
}
