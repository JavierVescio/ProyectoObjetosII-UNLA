package vista.sectorPersonal;

import negocio.sectorPersonal.TipoPersonalABM;

public class AgregarTipoPersonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoPersonalABM abmTipoPersonal = new TipoPersonalABM();
		String nombreTipoPersonal = "Valet Parking";
		
		try {
			int idTipoPersonal = abmTipoPersonal.agregarTipoPersonal(nombreTipoPersonal);
			System.out.println("\n"+idTipoPersonal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
