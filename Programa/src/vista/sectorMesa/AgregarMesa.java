package vista.sectorMesa;

import negocio.sectorMesa.MesaABM;

public class AgregarMesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MesaABM abmMesa = new MesaABM();

		try {
			int nroMesa = 10;
			int idMesa = abmMesa.agregarMesa(nroMesa);
		
			System.out.println("idMesa: "+idMesa);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
