package controladores.sectorMesa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.sectorMesa.MesaABM;
import negocio.sectorPersonal.PersonaABM;
import datos.sectorMesa.Mesa;
import datos.sectorPersonal.Cliente;
import datos.sectorPersonal.Personal;



public class ControladorOcuparMesa extends HttpServlet {

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
			MesaABM abmMesa = new MesaABM();
			PersonaABM abmPersona = new PersonaABM();
			
			int idcamarero = Integer.valueOf(request.getParameter("idcamarero").toString());
			int idcliente = Integer.valueOf(request.getParameter("idcliente").toString());
			int idmesa = Integer.valueOf(request.getParameter("idmesa").toString());
			int cantidadcomensales = Integer.valueOf(request.getParameter("cantidadcomensales").toString());
			
			Personal camarero = (Personal)abmPersona.traerPersonaPorId(idcamarero);
			Mesa mesa = abmMesa.traerMesaPorId(idmesa);
			Cliente cliente = (Cliente)abmPersona.traerPersonaPorId(idcliente);
			String habitacion = "";
			
			int idOcupacionMesa = abmMesa.agregarOcupacionMesa(cliente, camarero, mesa, cantidadcomensales, habitacion);
			
			
			request.setAttribute("idOcupacionMesa", idOcupacionMesa);
			request.getRequestDispatcher("/administracion.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
