package vista.sectorPersonal;

import datos.sectorPersonal.TipoCliente;
import negocio.sectorPersonal.TipoClienteABM;

public class ModificarTipoCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoClienteABM abmTipoCliente = new TipoClienteABM();
		
		
		try {
			TipoCliente tipoCliente = abmTipoCliente.traerTipoClientePorId(3);
			tipoCliente.setNombre("Normal");
			
			abmTipoCliente.modificar(tipoCliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
