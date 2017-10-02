package negocio.sectorPersonal;

import java.util.List;

import dao.sectorPersonal.*;
import datos.sectorPersonal.*;

public class TipoClienteABM {
	TipoClienteDao dao = new TipoClienteDao();


/* 1.ABM */
	public int agregarTipoCliente(String nombre) throws Exception {
		if (nombre.isEmpty())
			throw new Exception("nombre sin escribir");
		TipoCliente tipoCliente = new TipoCliente(nombre);
		return dao.agregar(tipoCliente);
	}

	public void modificar(TipoCliente tipoCliente) throws Exception {
		if (tipoCliente==null)
			throw new Exception("tipoCliente nulo");
		dao.actualizar(tipoCliente);	
	}

	public void eliminar(int idTipoCliente) throws Exception {
		TipoCliente tipoCliente = dao.traerTipoClientePorId(idTipoCliente);
		if (tipoCliente==null)
			throw new Exception("El idTipoCliente ingresado no se corresponde a ningun TipoCliente");
		dao.eliminar(tipoCliente);
	}
/* --- */

/* 2.TRAYENDO LA INFORMACION */
	public TipoCliente traerTipoClientePorId(int idTipoCliente) throws Exception{
		TipoCliente tipoCliente = dao.traerTipoClientePorId(idTipoCliente);
		if (tipoCliente==null)
			throw new Exception("tipoCliente nulo");
		return tipoCliente;
	}
	
	public List<TipoCliente> traerTipoClientes() throws Exception {
		List<TipoCliente> listaTipoCliente = dao.traerTipoClientes();
		if (listaTipoCliente.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaTipoCliente;
	}
/* --- */
}
