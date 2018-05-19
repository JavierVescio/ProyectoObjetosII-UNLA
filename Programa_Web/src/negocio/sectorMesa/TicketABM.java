package negocio.sectorMesa;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.sectorMesa.ComandaDao;
import dao.sectorMesa.TicketDao;
import dao.sectorPersonal.PersonaDao;
import datos.sectorMesa.Comanda;
import datos.sectorMesa.DetalleComanda;
import datos.sectorMesa.Ticket;
import datos.sectorPersonal.Personal;

public class TicketABM {
	ComandaDao daoComanda = new ComandaDao();
	PersonaDao daoPersona = new PersonaDao();
	TicketDao daoTicket = new TicketDao();
	MesaABM abmMesa = new MesaABM();
	
	public int agregarTicket(Comanda comanda, Personal personal) throws Exception {
		if (comanda == null)
			throw new Exception("comanda nula");
		if (daoComanda.traerComandaPorId(comanda.getIdComanda())==null)
			throw new Exception("comanda inexistente");
		if (personal == null)
			throw new Exception("personal nulo");
		if (daoPersona.traerPersonalPorCuil(personal.getCuil())==null)
			throw new Exception("personal inexistente");
		if (comanda.getOcupacionMesa().getMesa().getEstado() == 0)
			throw new Exception("no se puede generar un ticket de una mesa que esta desocupada");
		
		float importeTotal = 0;
		GregorianCalendar fechaEmision = new GregorianCalendar();
		
		Set<DetalleComanda> listDetalleComanda = comanda.getDetalleComandas();
		if (listDetalleComanda.isEmpty())
			throw new Exception("comanda sin detalleComandas");
		
		for(DetalleComanda detalleComanda: listDetalleComanda){
			importeTotal = importeTotal + (detalleComanda.getPrecio() * detalleComanda.getCantidad());
		}
		
		Ticket ticket = new Ticket(comanda, personal, importeTotal, fechaEmision);
		abmMesa.cerrarMesa(comanda.getOcupacionMesa());
		return daoTicket.agregar(ticket);
	}
	
	public Ticket traerTicketPorId(int idTicket) throws Exception{
		Ticket ticket = daoTicket.traerTicketPorId(idTicket);
		if (ticket == null)
			throw new Exception("ticket inexistente");
		return ticket;
	}
	
	public Ticket traerTicketPorIdConComandaYPersonal(int idTicket) throws Exception{
		Ticket ticket = daoTicket.traerTicketPorIdConComandaYPersonal(idTicket);
		if (ticket == null)
			throw new Exception("ticket inexistente");
		return ticket;
	}

	public List<Ticket> traerTickets() throws Exception {
		List<Ticket> listaTicket = daoTicket.traerTickets();
		System.out.println("cantidad: " + listaTicket.size());
		if (listaTicket.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaTicket;
	}
}
