package vista.sectorProducto;

import negocio.sectorProducto.ProductoABM;
import datos.sectorProducto.*;

public class ModificarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoABM abmProducto = new ProductoABM();
		
		try {
			Producto producto = abmProducto.traerProductoPorId(5);
			System.out.println(producto);
			producto.setImagen("No disponible");
			
			abmProducto.modificar(producto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
