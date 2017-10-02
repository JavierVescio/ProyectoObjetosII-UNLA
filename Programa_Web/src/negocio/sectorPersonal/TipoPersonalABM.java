package negocio.sectorPersonal;

import java.util.List;

import dao.sectorPersonal.*;
import datos.sectorPersonal.*;

public class TipoPersonalABM {
	TipoPersonalDao dao = new TipoPersonalDao();


/* 1.ABM */
	public int agregarTipoPersonal(String nombre) throws Exception {
		if (nombre.isEmpty())
			throw new Exception("nombre sin escribir");
		TipoPersonal tipoPersonal = new TipoPersonal(nombre);
		return dao.agregar(tipoPersonal);
	}

	public void modificar(TipoPersonal tipoPersonal) throws Exception {
		if (tipoPersonal==null)
			throw new Exception("tipoPersonal nulo");
		dao.actualizar(tipoPersonal);	
	}

	public void eliminar(int idTipoPersonal) throws Exception {
		TipoPersonal tipoPersonal = dao.traerTipoPersonalPorId(idTipoPersonal);
		if (tipoPersonal==null)
			throw new Exception("El idTipoPersonal ingresado no se corresponde a ningun TipoPersonal");
		dao.eliminar(tipoPersonal);
	}
/* --- */

/* 2.TRAYENDO LA INFORMACION */
	public TipoPersonal traerTipoPersonalPorId(int idTipoPersonal) throws Exception{
		TipoPersonal tipoPersonal = dao.traerTipoPersonalPorId(idTipoPersonal);
		if (tipoPersonal==null)
			throw new Exception("tipoPersonal nulo");
		return tipoPersonal;
	}
	
	public List<TipoPersonal> traerTipoPersonals() throws Exception {
		List<TipoPersonal> listaTipoPersonal = dao.traerTipoPersonals();
		if (listaTipoPersonal.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaTipoPersonal;
	}
/* --- */
}
