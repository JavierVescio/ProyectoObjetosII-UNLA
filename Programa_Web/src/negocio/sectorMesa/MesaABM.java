package negocio.sectorMesa;

import java.util.GregorianCalendar;
import java.util.List;

import dao.sectorMesa.*;
import dao.sectorPersonal.PersonaDao;
import datos.sectorMesa.*;
import datos.sectorPersonal.Cliente;
import datos.sectorPersonal.Personal;

public class MesaABM {
	MesaDao daoMesa = new MesaDao();
	OcupacionMesaDao daoOcupacionMesa = new OcupacionMesaDao();
	PersonaDao daoPersona = new PersonaDao();
	UnidadMesaDao daoUnidadMesa= new UnidadMesaDao();


/* 1.ABM */
	public int agregarMesa(int nroMesa) throws Exception {
		int estado = 0; //libre
		if (nroMesa < 1)
			throw new Exception("nroMesa debe ser mayor a cero");
				
		Mesa mesa = new Mesa(nroMesa, estado);
		return daoMesa.agregar(mesa);
	}
	
	//Permite agregar una unica unidad mesa a la mesa usando daoUnidadMesa
	public int agregarUnidadMesa(Mesa mesa) throws Exception {
		if (mesa==null)
			throw new Exception("mesa nulo");
		if (daoMesa.traerMesaPorId(mesa.getIdMesa())==null)
			throw new Exception("mesa inexistente");
		UnidadMesa unidadMesa = new UnidadMesa(mesa);
		return daoUnidadMesa.agregar(unidadMesa);
	}
	
	//Agrega las unidadesMesa al set de mesa y despues actualiza usando el dao de mesa.
	public void agregarUnidadesMesa(Mesa mesa, int cantidad) throws Exception {
		if (mesa==null)
			throw new Exception("mesa nulo");
		if (daoMesa.traerMesaPorId(mesa.getIdMesa())==null)
			throw new Exception("mesa inexistente");
		int x;
		for (x=0;x<cantidad;x++){
			UnidadMesa unidadMesa = new UnidadMesa(mesa);
			mesa.cargarUnidadMesa(unidadMesa);
		}
		daoMesa.actualizar(mesa);
	}
	
	public int agregarOcupacionMesa(Cliente cliente, Personal camarero, Mesa mesa, int cantidadComensales, String habitacion) throws Exception {
		if (cantidadComensales < 1)
			throw new Exception("cantidadComensales debe ser mayor a cero");
		if (cliente == null)
			throw new Exception("cliente nulo");
		else
			if (daoPersona.traerPersonaPorDni(cliente.getDni()) == null)
				throw new Exception("Cliente inexistente");
		if (camarero == null)
			throw new Exception("camarero nulo");
		else
			if (daoPersona.traerPersonalPorCuil(camarero.getCuil()) == null)
				throw new Exception("camarero inexistente");
		if (mesa==null)
			throw new Exception("mesa nulo");
		if (daoMesa.traerMesaPorId(mesa.getIdMesa())==null)
			throw new Exception("mesa inexistente");
		if (mesa.getEstado() == 1)
			throw new Exception("la mesa ya esta ocupada");
		
		OcupacionMesa ocupacionMesa = new OcupacionMesa(cliente, camarero, mesa, cantidadComensales, habitacion);
		mesa.setEstado(1);
		daoMesa.actualizar(mesa);
		return daoOcupacionMesa.agregar(ocupacionMesa);
	}
	
	public void cerrarMesa(OcupacionMesa ocupacionMesa) throws Exception{
		if (ocupacionMesa==null)
			throw new Exception("ocupacionMesa nulo");
		if (daoOcupacionMesa.traerOcupacionMesaPorId(ocupacionMesa.getIdOcupacionMesa())==null)
			throw new Exception("ocupacionMesa inexistente");
		
		ocupacionMesa.setFechaHoraFin(new GregorianCalendar());
		daoOcupacionMesa.actualizar(ocupacionMesa);
		ocupacionMesa.getMesa().setEstado(0); //Libero la mesa
		daoMesa.actualizar(ocupacionMesa.getMesa());
	}

	public void modificarMesa(Mesa mesa) throws Exception {
		if (mesa==null)
			throw new Exception("mesa nulo");
		daoMesa.actualizar(mesa);	
	}
	
	public void modificarUnidadMesa(UnidadMesa unidadMesa) throws Exception {
		if (unidadMesa==null)
			throw new Exception("unidadMesa nulo");
		daoUnidadMesa.actualizar(unidadMesa);	
	}

	public void eliminarMesa(int idMesa) throws Exception {
		Mesa mesa = daoMesa.traerMesaPorId(idMesa);
		if (mesa==null)
			throw new Exception("El idMesa ingresado no se corresponde a ningun Mesa");
		daoMesa.eliminar(mesa);
	}
	
	public void eliminarUnidadMesa(int idUnidadMesa) throws Exception {
		UnidadMesa unidadMesa = daoUnidadMesa.traerUnidadMesaPorId(idUnidadMesa);
		if (unidadMesa==null)
			throw new Exception("El idUnidadMesa ingresado no se corresponde a ningun UnidadMesa");
		daoUnidadMesa.eliminar(unidadMesa);
	}
/* --- */

/* 2.TRAYENDO LA INFORMACION */
	public Mesa traerMesaPorId(int idMesa) throws Exception{
		Mesa mesa = daoMesa.traerMesaPorId(idMesa);
		if (mesa==null)
			throw new Exception("mesa nulo");
		return mesa;
	}
	
	public List<Mesa> traerMesas() throws Exception {
		List<Mesa> listaMesa = daoMesa.traerMesas();
		if (listaMesa.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaMesa;
	}
	
	public List<OcupacionMesa> traerOcupacionMesas() throws Exception {
		List<OcupacionMesa> listaOcupacionMesas = daoOcupacionMesa.traerOcupacionMesas();
		if (listaOcupacionMesas.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaOcupacionMesas;
	}
	
	public UnidadMesa traerUnidadMesaPorId(int idUnidadMesa) throws Exception{
		UnidadMesa unidadMesa = daoUnidadMesa.traerUnidadMesaPorId(idUnidadMesa);
		if (unidadMesa==null)
			throw new Exception("unidadMesa nulo");
		return unidadMesa;
	}
	
	public List<UnidadMesa> traerUnidadMesas() throws Exception {
		List<UnidadMesa> listaUnidadMesa = daoUnidadMesa.traerUnidadMesas();
		if (listaUnidadMesa.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaUnidadMesa;
	}
	
	public OcupacionMesa traerOcupacionMesaPorId(int idOcupacionMesa) throws Exception {
		OcupacionMesa ocupacionMesa = daoOcupacionMesa.traerOcupacionMesaPorId(idOcupacionMesa);
		if (ocupacionMesa==null)
			throw new Exception("ocupacionMesa nulo");
		return ocupacionMesa;
	}
/* --- */
}
