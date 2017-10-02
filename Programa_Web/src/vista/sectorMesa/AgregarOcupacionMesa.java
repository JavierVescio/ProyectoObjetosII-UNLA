package vista.sectorMesa;

import datos.sectorMesa.Mesa;
import datos.sectorPersonal.Cliente;
import datos.sectorPersonal.Personal;
import negocio.sectorMesa.MesaABM;
import negocio.sectorPersonal.PersonaABM;

public class AgregarOcupacionMesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MesaABM abmMesa = new MesaABM();
		PersonaABM abmPersona = new PersonaABM();
		
		try {
			Mesa mesa = abmMesa.traerMesaPorId(4);	
			Personal camarero = abmPersona.traerPersonalPorCuil("20320578855");
			Cliente cliente = (Cliente)abmPersona.traerPersonaPorDni("36086446");
			int cantidadComensales = 3;
			String habitacion = "";
			
			int idOcupacionMesa = abmMesa.agregarOcupacionMesa(cliente, camarero, mesa, cantidadComensales, habitacion);
			System.out.println("idOcupacionMesa: "+idOcupacionMesa);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
