package vista.sectorProducto;

import negocio.sectorProducto.ProductoABM;

public class AgregarPlato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductoABM productoABM = new ProductoABM();
		int idProducto = productoABM.agregarPlato("Fideos", "Tallarines", "-", "Receta de la abuela");
		System.out.println("idProducto: " + idProducto);
	}
	
}
