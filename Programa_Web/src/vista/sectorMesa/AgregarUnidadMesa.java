package vista.sectorMesa;

import datos.sectorMesa.Mesa;
import negocio.sectorMesa.MesaABM;

public class AgregarUnidadMesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MesaABM abmMesa = new MesaABM();
		
		try {
			Mesa mesa = abmMesa.traerMesaPorId(1);
			int cantidadUnidadesMesa = 2;
			abmMesa.agregarUnidadesMesa(mesa, cantidadUnidadesMesa);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
