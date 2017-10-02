package vista.sectorMesa;

import datos.sectorMesa.OcupacionMesa;
import negocio.sectorMesa.ComandaABM;
import negocio.sectorMesa.MesaABM;

public class AgregarComanda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComandaABM abmComanda = new ComandaABM();
		MesaABM abmMesa = new MesaABM();
		
		try {
			OcupacionMesa ocupacionMesa = abmMesa.traerOcupacionMesaPorId(1);
			int idComanda = abmComanda.agregarComanda(ocupacionMesa);
			System.out.println("idComanda: "+idComanda);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
