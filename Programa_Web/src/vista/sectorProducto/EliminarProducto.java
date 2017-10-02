package vista.sectorProducto;

import negocio.sectorProducto.ProductoABM;

public class EliminarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoABM abmProducto = new ProductoABM();
		
		try {
			int idProducto = 5;
			abmProducto.eliminar(idProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
