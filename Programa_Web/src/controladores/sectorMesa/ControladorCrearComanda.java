package controladores.sectorMesa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.sectorMesa.ComandaABM;
import negocio.sectorMesa.MesaABM;
import negocio.sectorPersonal.PersonaABM;
import datos.sectorMesa.Mesa;
import datos.sectorMesa.OcupacionMesa;
import datos.sectorPersonal.Cliente;
import datos.sectorPersonal.Personal;



public class ControladorCrearComanda extends HttpServlet {

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
			MesaABM abmMesa = new MesaABM();
			
			int idocupacionmesa = Integer.valueOf(request.getParameter("idocupacionmesa").toString());
			
			OcupacionMesa ocupacionMesa = abmMesa.traerOcupacionMesaPorId(idocupacionmesa);
			int idComanda = abmComanda.agregarComanda(ocupacionMesa);
			
			
			request.setAttribute("msgTodoBien", "Creacion exitosa de comanda con id: " + String.valueOf(idComanda));
			request.getRequestDispatcher("/mesas/creardetallecomanda.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
