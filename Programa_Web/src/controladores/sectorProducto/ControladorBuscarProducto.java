package controladores.sectorProducto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.sectorProducto.Producto;
import negocio.sectorProducto.ProductoABM;


public class ControladorBuscarProducto extends HttpServlet {

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
			
			List<Producto> listaProductos = abmProducto.traerProductoPorNombre(nombreProducto);
			
			request.setAttribute("listaProductos", listaProductos);
			request.getRequestDispatcher("/productos/listado.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "Error Intente de nuevo");
		}
	}

}
