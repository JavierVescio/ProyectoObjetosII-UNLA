package vista.sectorPersonal;

import datos.sectorPersonal.LogIn;
import datos.sectorPersonal.TipoPersonal;
import negocio.sectorPersonal.LogInABM;
import negocio.sectorPersonal.PersonaABM;
import negocio.sectorPersonal.TipoPersonalABM;

public class AgregarPersonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		TipoPersonalABM abmTipoPersonal = new TipoPersonalABM();
		LogInABM abmLogIn = new LogInABM();

		String apellido = "Rivson";
		String nombre = "Ariel";
		String dni = "32057885";
		String cuil = "20320578855";
		
		try {
			TipoPersonal tipoPersonal = abmTipoPersonal.traerTipoPersonalPorId(4);
			LogIn logIn = abmLogIn.traerLogInPorId(2);

			int idPersonal = abmPersona.agregarPersonal(apellido, nombre, dni, logIn, tipoPersonal, cuil);
			
			System.out.println("idPersonal: "+idPersonal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
