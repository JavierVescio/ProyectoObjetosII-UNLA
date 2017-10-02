package vista.sectorProducto;

import datos.sectorProducto.*;
import negocio.sectorProducto.PrecioProductoABM;

public class TraerPrecioProductoPorId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
		
		try {
			PrecioProducto precioProducto = abmPrecioProducto.traerPrecioProductoPorId(1);
			System.out.println("\n"+precioProducto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
