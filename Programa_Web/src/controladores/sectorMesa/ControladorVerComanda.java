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



public class ControladorVerComanda extends HttpServlet {

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
			ComandaABM abmComanda = new ComandaABM();
			
			int idcomanda = Integer.valueOf(request.getParameter("idcomanda").toString());
			
			Comanda comanda = abmComanda.traerComandaYDetalleComandasPorId(idcomanda);
			
			
			request.setAttribute("comanda", comanda);
			request.getRequestDispatcher("/mesas/comanda.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
