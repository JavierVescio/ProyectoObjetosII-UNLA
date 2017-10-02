package negocio.sectorMesa;

import negocio.sectorProducto.PrecioProductoABM;
import dao.sectorMesa.ComandaDao;
import dao.sectorMesa.DetalleComandaDao;
import dao.sectorMesa.OcupacionMesaDao;
import dao.sectorProducto.ProductoDao;
import datos.sectorMesa.Comanda;
import datos.sectorMesa.DetalleComanda;
import datos.sectorMesa.OcupacionMesa;
import datos.sectorPersonal.Cliente;
import datos.sectorProducto.PrecioProducto;
import datos.sectorProducto.Producto;

public class DetalleComandaABM {
	ComandaDao daoComanda = new ComandaDao();
	DetalleComandaDao daoDetalleComanda = new DetalleComandaDao();
	ProductoDao daoProducto = new ProductoDao();
	OcupacionMesaDao daoOcupacionMesa = new OcupacionMesaDao();
	PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
	
	
	public int agregarDetalleComanda(Comanda comanda, Producto producto, int cantidad) throws Exception {
		if (comanda == null)
			throw new Exception("comanda nula");
		if (daoProducto.traerProductoPorId(producto.getIdProducto())==null)
			throw new Exception("producto inexistente");	
		Comanda comandaAux = daoComanda.traerComandaPorId(comanda.getIdComanda());
		if (comandaAux == null)
			throw new Exception("comanda inexistente");
		if (comandaAux.getAnulada() == true)
			throw new Exception("no puede agregar un detalle de comanda a una comanda anulada");
		
		PrecioProducto precioProducto = calcularPrecio(comanda, producto);
		if (precioProducto == null)
			throw new Exception("precioProducto nula");
		
		DetalleComanda detalleComanda = new DetalleComanda(comanda, producto, cantidad, (float)precioProducto.getPrecio());
		return daoDetalleComanda.agregar(detalleComanda);
	}
	
	public void modificarDetalleComanda(DetalleComanda detalleComanda) throws Exception {
		if (detalleComanda == null)
			throw new Exception("detalleComanda nula");
		daoDetalleComanda.actualizar(detalleComanda);
	}
	
	public void anularDetalleComanda(DetalleComanda detalleComanda) throws Exception {
		if (detalleComanda == null)
			throw new Exception("detalleComanda nulo");
		DetalleComanda auxDetalleComanda = daoDetalleComanda.traerDetalleComandaPorId(detalleComanda.getIdDetalleComanda());
		if (auxDetalleComanda == null)
			throw new Exception("detalleComanda inexistente");
		if (auxDetalleComanda.getAnulada()==false) 
			throw new Exception("El detalleComanda ya estaba anulado");
		detalleComanda.setAnulada(true);
		daoDetalleComanda.actualizar(detalleComanda);
	}
	
	public DetalleComanda traerDetalleComandaPorId(int idDetalleComanda) throws Exception {
		DetalleComanda detalleComanda = daoDetalleComanda.traerDetalleComandaPorId(idDetalleComanda);
		if (detalleComanda == null)
			throw new Exception("comanda nula");
		return detalleComanda;
	}
	
	private PrecioProducto calcularPrecio(Comanda comanda, Producto producto) throws Exception {
		Comanda comandaAux = daoComanda.traerComandaYDetalleComandasPorId(comanda.getIdComanda());
		if (comandaAux == null)
			throw new Exception("comanda inexistente");
		if (daoProducto.traerProductoPorId(producto.getIdProducto())==null)
			throw new Exception("producto inexistente");
		
		OcupacionMesa ocupacionMesa = daoOcupacionMesa.traerOcupacionMesaPorId(comanda.getOcupacionMesa().getIdOcupacionMesa());
		Cliente cliente = ocupacionMesa.getCliente();
		PrecioProducto precioProducto = abmPrecioProducto.traerPrecioProductoMasRecientePorCliente(producto, cliente);
		return precioProducto;
	}
}

