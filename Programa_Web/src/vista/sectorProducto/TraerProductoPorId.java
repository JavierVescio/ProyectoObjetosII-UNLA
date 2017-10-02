package vista.sectorProducto;

import datos.sectorProducto.*;
import negocio.sectorProducto.ProductoABM;

public class TraerProductoPorId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoABM abmProducto = new ProductoABM();
		
		try {
			Producto producto = abmProducto.traerProductoPorId(6);
			System.out.println(producto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
