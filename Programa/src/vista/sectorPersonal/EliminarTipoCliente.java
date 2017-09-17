package vista.sectorPersonal;

import negocio.sectorPersonal.TipoClienteABM;

public class EliminarTipoCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoClienteABM abmTipoCliente = new TipoClienteABM();
		
		try {
			int idTipoCliente = 3;
			abmTipoCliente.eliminar(idTipoCliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
