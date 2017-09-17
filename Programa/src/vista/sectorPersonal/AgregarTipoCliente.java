package vista.sectorPersonal;

import negocio.sectorPersonal.TipoClienteABM;

public class AgregarTipoCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoClienteABM abmTipoCliente = new TipoClienteABM();
		String nombreTipoCliente = "Popular";
		
		try {
			int idTipoCliente = abmTipoCliente.agregarTipoCliente(nombreTipoCliente);
			System.out.println("\n"+idTipoCliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
