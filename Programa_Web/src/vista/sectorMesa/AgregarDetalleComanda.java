package vista.sectorMesa;

import negocio.sectorMesa.ComandaABM;
import negocio.sectorMesa.DetalleComandaABM;
import negocio.sectorProducto.ProductoABM;
import datos.sectorMesa.Comanda;
import datos.sectorProducto.Producto;

public class AgregarDetalleComanda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComandaABM abmComanda = new ComandaABM();
		DetalleComandaABM abmDetalleComanda = new DetalleComandaABM();
		ProductoABM abmProducto = new ProductoABM();
		
		try {
			Comanda comanda = abmComanda.traerComandaYDetalleComandasPorId(1);
			Producto producto = abmProducto.traerProductoPorId(7);
			int cantidad = 1;
			
			int idDetalleComanda = abmDetalleComanda.agregarDetalleComanda(comanda, producto, cantidad);
			System.out.println("idDetalleComanda: "+idDetalleComanda);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
