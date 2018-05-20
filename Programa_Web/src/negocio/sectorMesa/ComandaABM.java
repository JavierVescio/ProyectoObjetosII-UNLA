package negocio.sectorMesa;

import java.util.List;

import negocio.sectorProducto.PrecioProductoABM;
import dao.sectorMesa.ComandaDao;
import dao.sectorMesa.MesaDao;
import dao.sectorMesa.OcupacionMesaDao;
import dao.sectorProducto.ProductoDao;
import datos.sectorMesa.Comanda;
import datos.sectorMesa.DetalleComanda;
import datos.sectorMesa.OcupacionMesa;
import datos.sectorPersonal.Cliente;
import datos.sectorProducto.PrecioProducto;
import datos.sectorProducto.Producto;

public class ComandaABM {
	ComandaDao daoComanda = new ComandaDao();
	OcupacionMesaDao daoOcupacionMesa = new OcupacionMesaDao();
	MesaDao daoMesa = new MesaDao();
	ProductoDao daoProducto = new ProductoDao();
	PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
	
	public int agregarComanda(OcupacionMesa ocupacionMesa) throws Exception {
		if (ocupacionMesa == null)
			throw new Exception("ocupacionMesa nula");		
		OcupacionMesa auxOcupacionMesa = daoOcupacionMesa.traerOcupacionMesaPorId(ocupacionMesa.getIdOcupacionMesa());
		if (auxOcupacionMesa == null)
			throw new Exception("ocupacionMesa inexistente");
		if (auxOcupacionMesa.getFechaHoraFin() != null)
			throw new Exception("no puede agregar comandas en un registro de ocupacion de mesa pasado");
		
		Comanda comanda = new Comanda(ocupacionMesa);
		return daoComanda.agregar(comanda);
	}
	
	public void agregarDetalleComanda(Comanda comanda, Producto producto, int cantidad) throws Exception {
		if (comanda==null)
			throw new Exception("comanda nulo");
		if (daoComanda.traerComandaPorId(comanda.getIdComanda())==null)
			throw new Exception("comanda inexistente");
		if (producto==null)
			throw new Exception("producto nulo");
		if (daoProducto.traerProductoPorId(producto.getIdProducto())==null)
			throw new Exception("producto inexistente");	
		
		PrecioProducto precioProducto = calcularPrecio(comanda, producto);
		if (precioProducto == null)
			throw new Exception("precioProducto nula");
		
		DetalleComanda detalleComanda = new DetalleComanda(comanda, producto, cantidad, (float)precioProducto.getPrecio());
		comanda.cargarDetalleComanda(detalleComanda);
		
		daoComanda.actualizar(comanda);
	}
	
	public void modificarComanda(Comanda comanda) throws Exception {
		if (comanda == null)
			throw new Exception("comanda nula");
		daoComanda.actualizar(comanda);
	}
	
	public void anularComanda(Comanda comanda) throws Exception {
		if (comanda == null)
			throw new Exception("comanda nula");
		Comanda auxComanda = daoComanda.traerComandaPorId(comanda.getIdComanda());
		if (auxComanda == null)
			throw new Exception("comanda inexistente");
		if (auxComanda.getAnulada()==false) 
			throw new Exception("la comanda ya estaba anulada");
		comanda.setAnulada(true);
		daoComanda.actualizar(comanda);
	}
	
	public Comanda traerComandaPorId(int idComanda) throws Exception {
		Comanda comanda = daoComanda.traerComandaPorId(idComanda);
		if (comanda == null)
			throw new Exception("comanda nula");
		return comanda;
	}
	
	public Comanda traerComandaYDetalleComandasPorId(int idComanda) throws Exception {
		Comanda comanda = daoComanda.traerComandaYDetalleComandasPorId(idComanda);
		if (comanda == null){
			System.out.println("comanda nulaaaaaa");
			throw new Exception("comanda nula");
		}
		return comanda;
	}
	
	public List<Comanda> traerComandas() throws Exception {
		List<Comanda> listaComanda = daoComanda.traerComandas();
		if (listaComanda.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaComanda;
	}
	
	public List<Comanda> traerComandasAptasParaGenerarTicket() throws Exception {
		List<Comanda> listaComanda = daoComanda.traerComandasAptasParaGenerarTicket();
		if (listaComanda.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaComanda;
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
