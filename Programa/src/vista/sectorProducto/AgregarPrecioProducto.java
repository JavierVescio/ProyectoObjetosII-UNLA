package vista.sectorProducto;

import java.util.GregorianCalendar;

import datos.sectorPersonal.TipoCliente;
import datos.sectorProducto.Producto;
import negocio.sectorProducto.PrecioProductoABM;
import negocio.sectorProducto.ProductoABM;

public class AgregarPrecioProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
		ProductoABM abmProducto = new ProductoABM();
		//A la fecha 7 de septiembre 2017, aun faltan crear los ABM relativos al personal.
	
		try {
			double precio = 450;
			GregorianCalendar fecha = new GregorianCalendar();
			Producto producto = abmProducto.traerProductoPorId(6);
			TipoCliente tipoCliente = null; //TipoCliente tipoCliente = abm.traerTipoClientePorId(1);
		
			int idPrecioProducto = abmPrecioProducto.agregarPrecioProducto(precio, fecha, producto, tipoCliente);
			System.out.println("idPrecioProducto: " + idPrecioProducto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
}
