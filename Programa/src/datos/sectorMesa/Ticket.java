package datos.sectorMesa;

import java.util.GregorianCalendar;

import datos.sectorPersonal.*;

public class Ticket {
	private int idTicket;
	private Comanda comanda;
	private Personal personal;
	private float importeTotal;
	private GregorianCalendar fechaEmision;
	
	public Ticket() {
	
	}
	
	public Ticket(Comanda comanda, Personal personal, float importeTotal,
			GregorianCalendar fechaEmision) {
		super();
		this.comanda = comanda;
		this.personal = personal;
		this.importeTotal = importeTotal;
		this.fechaEmision = fechaEmision;
	}

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public float getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}

	public GregorianCalendar getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(GregorianCalendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", comanda=" + comanda
				+ ", personal=" + personal + ", importeTotal=" + importeTotal
				+ ", fechaEmision=" + fechaEmision + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTicket;
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
		Ticket other = (Ticket) obj;
		if (idTicket != other.idTicket)
			return false;
		return true;
	}
	
	
}

