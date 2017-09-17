package vista.sectorPersonal;

import datos.sectorPersonal.TipoPersonal;
import negocio.sectorPersonal.TipoPersonalABM;

public class TraerTipoPersonalPorId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoPersonalABM abmTipoPersonal = new TipoPersonalABM();
		
		try {
			TipoPersonal tipoPersonal = abmTipoPersonal.traerTipoPersonalPorId(2);
			System.out.println(tipoPersonal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
