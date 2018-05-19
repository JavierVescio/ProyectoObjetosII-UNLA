package controladores.sectorProducto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.sectorProducto.ProductoABM;


public class ControladorBebida extends HttpServlet {

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
			String notasBebida = request.getParameter("notasBebida");
			
			 if (nombreProducto.isEmpty()){
				request.setAttribute("msgError", "El nombre del producto no puede quedar en blanco");
				request.getRequestDispatcher("/productos/cargarbebida.jsp").forward(request, response);
			}
			 else{
					int idProducto = abmProducto.agregarBebida(nombreProducto, descripcionProducto, "", notasBebida);
					request.setAttribute("msgTodoBien", "Creacion exitosa de bebida con nombre " + nombreProducto);
					request.getRequestDispatcher("/productos/cargarbebida.jsp").forward(request, response);
			 }
			

			
			/*
			 if (nombreProducto.isEmpty()){
				request.setAttribute("msgError", "El nombre del producto no puede quedar en blanco");
				request.getRequestDispatcher("/productos/cargarplato.jsp").forward(request, response);
			}
			else {
				int idProducto = abmProducto.agregarPlato(nombreProducto, descripcionProducto, "", notasPlato);
				request.setAttribute("msgTodoBien", "Creacion exitosa de plato con nombre " + nombreProducto);
				request.getRequestDispatcher("/productos/cargarplato.jsp").forward(request, response);	
			}
			 * */
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
