package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.sectorPersonal.LogInABM;
import datos.sectorPersonal.Personal;;

public class ControladorLogIn extends HttpServlet {

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
			String user = request.getParameter("usuario");
			String pass = request.getParameter("password");

			if (user.isEmpty() || pass.isEmpty()){
				request.setAttribute("msgError", "Debe escribir un usuario y contraseña.");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				LogInABM loginabm = new LogInABM();
				Personal usuario = loginabm.iniciarSesion(user, pass);
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("/administracion.jsp").forward(request, response);
			}
		} catch (Exception e) {
			//response.sendError(500, "Error Intente de nuevo");
			request.setAttribute("msgError", "Usuario o contraseña incorrecto.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
