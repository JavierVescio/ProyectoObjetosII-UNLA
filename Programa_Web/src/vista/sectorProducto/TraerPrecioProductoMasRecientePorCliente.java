package vista.sectorProducto;

import datos.sectorProducto.*;
import datos.sectorPersonal.*;
import negocio.sectorProducto.PrecioProductoABM;
import negocio.sectorProducto.ProductoABM;

public class TraerPrecioProductoMasRecientePorCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
		ProductoABM abmProducto = new ProductoABM();
		//ClienteABM abmCliente = new ClienteABM(); //Al 07/09/17, aun no se encuentra disponible el ABM de Cliente.

		try {
			Producto producto = abmProducto.traerProductoPorId(6);
			Cliente cliente = null; //Cliente cliente = abmCliente.traerClientePorId(1);
			
			PrecioProducto precioProducto = abmPrecioProducto.traerPrecioProductoMasRecientePorCliente(producto, cliente);
			System.out.println("\n"+precioProducto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
