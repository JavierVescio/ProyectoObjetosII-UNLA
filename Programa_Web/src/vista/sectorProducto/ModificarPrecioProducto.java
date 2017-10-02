package vista.sectorProducto;

import negocio.sectorProducto.PrecioProductoABM;
import datos.sectorProducto.*;

public class ModificarPrecioProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
		
		try {
			PrecioProducto precioProducto = abmPrecioProducto.traerPrecioProductoPorId(3);
			System.out.println(precioProducto);
			precioProducto.setPrecio(60);
			
			abmPrecioProducto.modificar(precioProducto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
