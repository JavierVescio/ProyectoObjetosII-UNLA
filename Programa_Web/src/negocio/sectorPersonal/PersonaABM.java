package negocio.sectorPersonal;

import dao.sectorPersonal.*;
import datos.sectorPersonal.*;
import java.util.List;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();


/* 1.ABM */
	public int agregarPersonal(String apellido, String nombre, String dni, LogIn logIn, TipoPersonal tipoPersonal, String cuil) throws Exception {
		if (apellido.isEmpty() || nombre.isEmpty() || dni.isEmpty())
			throw new Exception("apellido, nombre o dni sin escribir");
		Persona persona = new Personal(dni, nombre, apellido, logIn, tipoPersonal, cuil);
		return dao.agregar(persona);
	}
	
	public int agregarCliente(String apellido, String nombre, String dni, TipoCliente tipoCliente) throws Exception {
		if (apellido.isEmpty() || nombre.isEmpty() || dni.isEmpty())
			throw new Exception("apellido, nombre o dni sin escribir");
		Persona persona = new Cliente(dni, nombre, apellido, tipoCliente);
		return dao.agregar(persona);
	}

	public void modificar(Persona persona) throws Exception {
		if (persona==null)
			throw new Exception("persona nulo");
		dao.actualizar(persona);	
	}

	public void eliminar(int idPersona) throws Exception {
		Persona persona = dao.traerPersonaPorId(idPersona);
		if (persona==null)
			throw new Exception("El idPersona ingresado no se corresponde a ningun Persona");
		dao.eliminar(persona);
	}
/* --- */

/* 2.TRAYENDO LA INFORMACION */
	public Persona traerPersonaPorId(int idPersona) throws Exception{
		Persona persona = dao.traerPersonaPorId(idPersona);
		if (persona==null)
			throw new Exception("persona nulo");
		return persona;
	}
	
	public Persona traerPersonaPorDni(String dni) throws Exception{
		Persona persona = dao.traerPersonaPorDni(dni);
		if (persona==null)
			throw new Exception("persona nulo");
		return persona;
	}
	
	public Personal traerPersonalPorCuil(String cuil) throws Exception{
		Personal personal = dao.traerPersonalPorCuil(cuil);
		if (personal==null)
			throw new Exception("personal nulo");
		return personal;
	}
	
	public List<Cliente> traerClientes() throws Exception {
		List<Cliente> lista = dao.traerClientes();
		if (lista.isEmpty())
			throw new Exception("lista nulo");
		return lista;
	}

	public List<Personal> traerCamareros() throws Exception {
		List<Personal> lista = dao.traerCamareros();
		if (lista.isEmpty())
			throw new Exception("lista nulo");
		return lista;
	}
	
	public int traerPersonalConCantidadDeMesasAsignadas(int idPersonal){
		return dao.traerPersonalConCantidadDeMesasAsignadas(idPersonal);
	}
	
	
/* --- */
}
