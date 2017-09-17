package vista.sectorPersonal;

import negocio.sectorPersonal.TipoPersonalABM;

public class EliminarTipoPersonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoPersonalABM abmTipoPersonal = new TipoPersonalABM();
		
		try {
			int idTipoPersonal = 3;
			abmTipoPersonal.eliminar(idTipoPersonal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
