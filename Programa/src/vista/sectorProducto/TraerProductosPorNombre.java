package vista.sectorProducto;

import java.util.List;

import datos.sectorProducto.*;
import negocio.sectorProducto.ProductoABM;

public class TraerProductosPorNombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoABM abmProducto = new ProductoABM();
		
		try {
			String nombreProducto = "s";
			List<Producto> listaProductos = abmProducto.traerProductoPorNombre(nombreProducto);
			
			System.out.println("\n");
			for(Producto producto: listaProductos){
				System.out.println(producto);
				System.out.println("\n");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
