package vista.sectorPersonal;

import datos.sectorPersonal.TipoCliente;
import negocio.sectorPersonal.TipoClienteABM;

public class TraerTipoClientePorId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoClienteABM abmTipoCliente = new TipoClienteABM();
		
		try {
			TipoCliente tipoCliente = abmTipoCliente.traerTipoClientePorId(2);
			System.out.println(tipoCliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
