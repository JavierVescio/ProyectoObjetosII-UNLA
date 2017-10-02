package negocio.sectorPersonal;

import dao.sectorPersonal.*;
import datos.sectorPersonal.*;

public class LogInABM {
	LogInDao daoLogIn = new LogInDao();
	PersonaDao daoPersona = new PersonaDao();


/* 1.ABM */
	public int agregarLogIn(String usuario, String contrasenia) throws Exception {
		if (usuario.isEmpty())
			throw new Exception("usuario sin escribir");
		if (contrasenia.isEmpty())
			throw new Exception("contrasenia sin escribir");
		LogIn logIn = new LogIn(usuario,contrasenia);
		return daoLogIn.agregar(logIn);
	}

	public void modificar(LogIn logIn) throws Exception {
		if (logIn==null)
			throw new Exception("logIn nulo");
		daoLogIn.actualizar(logIn);	
	}

	public void eliminar(int idLogIn) throws Exception {
		LogIn logIn = daoLogIn.traerLogInPorId(idLogIn);
		if (logIn==null)
			throw new Exception("El idLogIn ingresado no se corresponde a ningun LogIn");
		daoLogIn.eliminar(logIn);
	}
/* --- */

/* 2.TRAYENDO LA INFORMACION */
	public LogIn traerLogInPorId(int idLogIn) throws Exception{
		LogIn logIn = daoLogIn.traerLogInPorId(idLogIn);
		if (logIn==null)
			throw new Exception("logIn nulo");
		return logIn;
	}
	
	public Personal iniciarSesion(String usuario, String contrasenia) throws Exception {
		Personal personal = null;
		LogIn logIn = null;
		
		if (usuario.isEmpty())
			throw new Exception("usuario sin escribir");
		if (contrasenia.isEmpty())
			throw new Exception("contrasenia sin escribir");
		
		
		logIn = daoLogIn.traerLogInPorUsuarioContrasenia(usuario, contrasenia);
		
		if (logIn == null)
			throw new Exception("Usuario o contrasenia incorrecta");
		
		personal = daoPersona.traerPersonalPorIdLogIn(logIn.getIdLogIn());
		
		
		if (personal == null)
			throw new Exception("No hay personal asociado al logIn");
		
		logIn.setEnLinea(true);
		daoLogIn.actualizar(logIn);
		
		return personal;
	}
	
	public void cerrarSesion(LogIn logIn) throws Exception {
		if (logIn == null)
			throw new Exception("logIn nulo");
		
		if (daoLogIn.traerLogInPorId(logIn.getIdLogIn()).getEnLinea() == false)
			throw new Exception("La sesion ya se encontraba cerrada");
		
		logIn.setEnLinea(false);
		daoLogIn.actualizar(logIn);
	}
/* --- */
}
