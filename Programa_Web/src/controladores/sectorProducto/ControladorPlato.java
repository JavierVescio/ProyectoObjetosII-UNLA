package controladores.sectorProducto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.sectorProducto.ProductoABM;


public class ControladorPlato extends HttpServlet {

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
			ProductoABM abmProducto = new ProductoABM();
			
			String nombreProducto = request.getParameter("nombreProducto");
			String descripcionProducto = request.getParameter("descripcionProducto");
			String notasPlato = request.getParameter("notasPlato");
			
			int idProducto = abmProducto.agregarPlato(nombreProducto, descripcionProducto, "", notasPlato);
			/*Personal usuario = loginabm.iniciarSesion(user, pass);
			request.setAttribute("usuario", usuario);
			System.out.println ("Hola Mundo");*/
			System.out.println ("Carga de plaaato");
			request.setAttribute("idProducto", idProducto);
			request.getRequestDispatcher("/administracion.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
