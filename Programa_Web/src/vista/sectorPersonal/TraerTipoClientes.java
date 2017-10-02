package vista.sectorPersonal;

import java.util.List;

import datos.sectorPersonal.TipoCliente;
import negocio.sectorPersonal.TipoClienteABM;

public class TraerTipoClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoClienteABM abmTipoCliente = new TipoClienteABM();
		
		try {
			List<TipoCliente> listaTipoClientes = abmTipoCliente.traerTipoClientes();
			
			System.out.println("\n");
			for(TipoCliente tipoCliente: listaTipoClientes){
				System.out.println(tipoCliente);
				System.out.println("\n");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
