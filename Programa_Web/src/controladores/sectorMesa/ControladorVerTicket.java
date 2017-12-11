package controladores.sectorMesa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.sectorMesa.ComandaABM;
import negocio.sectorMesa.MesaABM;
import negocio.sectorMesa.TicketABM;
import datos.sectorMesa.*;



public class ControladorVerTicket extends HttpServlet {

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
			
			int idticket = Integer.valueOf(request.getParameter("idticket").toString());
			
			Ticket ticket = abmTicket.traerTicketPorIdConComandaYPersonal(idticket);
			
			
			request.setAttribute("ticket", ticket);
			request.getRequestDispatcher("/mesas/ticket.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
