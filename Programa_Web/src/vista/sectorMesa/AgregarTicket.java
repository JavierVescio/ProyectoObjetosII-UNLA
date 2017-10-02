package vista.sectorMesa;

import datos.sectorMesa.Comanda;
import datos.sectorPersonal.Personal;
import negocio.sectorMesa.ComandaABM;
import negocio.sectorMesa.TicketABM;
import negocio.sectorPersonal.PersonaABM;

public class AgregarTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM abmTicket = new TicketABM();
		ComandaABM abmComanda = new ComandaABM();
		PersonaABM abmPersona = new PersonaABM();
		
		int idComanda = 1;
		try {
			Comanda comanda = abmComanda.traerComandaYDetalleComandasPorId(idComanda);
			String cuil = "20320578855";
			Personal personal = abmPersona.traerPersonalPorCuil(cuil);
			
			int idTicket = abmTicket.agregarTicket(comanda, personal);
			System.out.println("idTicket: "+idTicket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
