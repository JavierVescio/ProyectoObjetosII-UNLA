package vista.sectorProducto;

import negocio.sectorProducto.ProductoABM;

public class AgregarPlato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductoABM abmProducto = new ProductoABM();
		String nombreProducto = "Fideos a la bolognesa";
		String descripcionProducto = "Plato de fideos con salsa";
		String imagenProducto = "-";
		String notasPlato = "Incluye dos sobresitos de queso de rallar";
		
		try {
			int idProducto = abmProducto.agregarPlato(nombreProducto, descripcionProducto, imagenProducto, notasPlato);
			System.out.println("idProducto: " + idProducto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
