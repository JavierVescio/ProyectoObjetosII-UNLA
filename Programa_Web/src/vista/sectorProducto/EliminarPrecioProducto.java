package vista.sectorProducto;

import negocio.sectorProducto.PrecioProductoABM;

public class EliminarPrecioProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrecioProductoABM abmPrecioProducto = new PrecioProductoABM();
		
		try {
			int idPrecioProducto = 5;
			abmPrecioProducto.eliminar(idPrecioProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
