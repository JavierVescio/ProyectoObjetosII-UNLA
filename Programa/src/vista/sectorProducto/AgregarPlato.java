package vista.sectorProducto;

import negocio.sectorProducto.ProductoABM;

public class AgregarPlato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductoABM productoABM = new ProductoABM();
		int idProducto = productoABM.agregarPlato("Fideos", "A la boloniesa", "-", "Son muy ricos");
		System.out.println("idProducto: " + idProducto);
	}
	
}
