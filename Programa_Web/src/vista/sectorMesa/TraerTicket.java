package vista.sectorMesa;

import datos.sectorMesa.Ticket;
import negocio.sectorMesa.TicketABM;

public class TraerTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM abmTicket = new TicketABM();
		int idTicket = 1;
		
		try {
			Ticket ticket = abmTicket.traerTicketPorIdConComandaYPersonal(idTicket);
			System.out.println(ticket);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
