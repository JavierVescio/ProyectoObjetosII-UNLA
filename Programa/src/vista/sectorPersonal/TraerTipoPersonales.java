package vista.sectorPersonal;

import java.util.List;

import datos.sectorPersonal.TipoPersonal;
import negocio.sectorPersonal.TipoPersonalABM;

public class TraerTipoPersonales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoPersonalABM abmTipoPersonal = new TipoPersonalABM();
		
		try {
			List<TipoPersonal> listaTipoPersonals = abmTipoPersonal.traerTipoPersonals();
			
			System.out.println("\n");
			for(TipoPersonal tipoPersonal: listaTipoPersonals){
				System.out.println(tipoPersonal);
				System.out.println("\n");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
