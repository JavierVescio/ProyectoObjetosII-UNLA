package datos.sectorMesa;

import java.util.GregorianCalendar;
import java.util.Set;

import datos.sectorPersonal.*;

public class Mesa {
	private enum estadoMesa {libre,ocupado,terminado};
	
	private int idMesa;
	private Cliente cliente;
	private Personal personal;
	private GregorianCalendar fechaHoraInicio;
	private GregorianCalendar fechaHoraFin;
	private String habitacion;
	private estadoMesa estado;
	private Set<UnidadMesa> unidades;
	
	public Mesa(){}

	public Mesa(Cliente cliente, Personal personal,
			GregorianCalendar fechaHoraInicio, GregorianCalendar fechaHoraFin,
			String habitacion, estadoMesa estado, Set<UnidadMesa> unidades) {
		super();
		this.cliente = cliente;
		this.personal = personal;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.habitacion = habitacion;
		this.unidades = unidades;
		this.estado = estado;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
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

	public estadoMesa getEstado() {
		return estado;
	}

	public void setEstado(estadoMesa estado) {
		this.estado = estado;
	}
	
	public Set<UnidadMesa> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<UnidadMesa> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", cliente=" + cliente
				+ ", personal=" + personal + ", fechaHoraInicio="
				+ fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin
				+ ", habitacion=" + habitacion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMesa;
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
		Mesa other = (Mesa) obj;
		if (idMesa != other.idMesa)
			return false;
		return true;
	}
	
}
