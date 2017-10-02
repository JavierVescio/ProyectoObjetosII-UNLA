package negocio.sectorProducto;

import java.util.GregorianCalendar;
import java.util.List;

import negocio.Funciones;
import dao.sectorProducto.PrecioProductoDao;
import datos.sectorPersonal.*;
import datos.sectorProducto.*;

public class PrecioProductoABM {
	PrecioProductoDao dao = new PrecioProductoDao();


/* 1.ABM */
	public int agregarPrecioProducto(double precio, GregorianCalendar fechaCreacion, Producto producto, TipoCliente tipoCliente) throws Exception {
		if (producto==null)
			throw new Exception("producto nulo");
		if (tipoCliente==null)
			throw new Exception("tipoCliente nulo");
		PrecioProducto precioProducto = new PrecioProducto(precio, fechaCreacion, producto, tipoCliente);
		return dao.agregar(precioProducto);
	}

	public void modificar(PrecioProducto precioProducto) throws Exception {
		if (precioProducto==null)
			throw new Exception("precioProducto nulo");
		dao.actualizar(precioProducto);	
	}

	public void eliminar(int idPrecioProducto) throws Exception {
		PrecioProducto precioProducto = dao.traerPrecioProductoPorId(idPrecioProducto);
		if (precioProducto==null)
			throw new Exception("El idPrecioProducto ingresado no se corresponde a ningun precioProducto");
		dao.eliminar(precioProducto);
	}
/* --- */

/* 2.TRAYENDO LA INFORMACION */
	public PrecioProducto traerPrecioProductoPorId(int idPrecioProducto) throws Exception{
		PrecioProducto precioProducto = dao.traerPrecioProductoPorId(idPrecioProducto);
		if (precioProducto==null)
			throw new Exception("precioProducto nulo");
		return precioProducto;
	}
	
	public PrecioProducto traerPrecioProductoMasRecientePorCliente(Producto producto, Cliente cliente) throws Exception {
		if (producto==null)
			throw new Exception("producto nulo");
		if (cliente==null)
			throw new Exception("cliente nulo");
		
		System.out.println("\n\n traerPrecioProductoMasRecientePorCliente \n");
		System.out.println("producto: " + producto);
		System.out.println("tipoCliente: " + cliente.getTipoCliente());
		
		
		List<PrecioProducto> listaPrecioProducto = dao.traerPrecioProductoPorCliente(producto.getIdProducto(), cliente.getTipoCliente().getIdTipoCliente());
		
		if (listaPrecioProducto.isEmpty())
			throw new Exception("No hay precios asociados al producto para el tipo de cliente seleccionado");
		
		PrecioProducto precioProductoMasReciente = null;
		
		for(PrecioProducto precioProducto: listaPrecioProducto){
			if (precioProductoMasReciente == null){
				precioProductoMasReciente = precioProducto;
			}
			else {
				if (Funciones.esFechaPosterior(precioProducto.getFechaCreacion(), precioProductoMasReciente.getFechaCreacion())){
					precioProductoMasReciente = precioProducto;
				}
			}
		}
		
		return precioProductoMasReciente;
	}
/* --- */
}
