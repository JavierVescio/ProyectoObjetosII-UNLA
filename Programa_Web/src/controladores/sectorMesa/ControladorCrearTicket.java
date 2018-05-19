package controladores.sectorMesa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.sectorMesa.ComandaABM;
import negocio.sectorMesa.MesaABM;
import negocio.sectorMesa.TicketABM;
import negocio.sectorPersonal.PersonaABM;
import datos.sectorMesa.Comanda;
import datos.sectorMesa.Mesa;
import datos.sectorMesa.OcupacionMesa;
import datos.sectorPersonal.Cliente;
import datos.sectorPersonal.Personal;



public class ControladorCrearTicket extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			TicketABM abmTicket = new TicketABM();
			ComandaABM abmComanda = new ComandaABM();
			PersonaABM abmPersona = new PersonaABM();

			int idpersonal = Integer.valueOf(request.getParameter("idpersonal").toString());
			int idcomanda = Integer.valueOf(request.getParameter("idcomanda").toString());

			if (idpersonal == -1 || idcomanda == -1) {
				request.setAttribute("msgError", "Debe seleccionar un cajero y una comanda.");
				request.getRequestDispatcher("/mesas/generarticket.jsp").forward(request, response);
			}
			else {
				Comanda comanda = abmComanda.traerComandaYDetalleComandasPorId(idcomanda);
				Personal personal = (Personal)abmPersona.traerPersonaPorId(idpersonal);

				int idTicket = abmTicket.agregarTicket(comanda, personal);

				request.setAttribute("msgTodoBien", "Creación de ticket exitosa. Ticket Nº: " + String.valueOf(idTicket));
				request.getRequestDispatcher("/mesas/generarticket.jsp").forward(request, response);
			}
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
