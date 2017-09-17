package vista.sectorPersonal;

import datos.sectorPersonal.Personal;
import negocio.sectorPersonal.LogInABM;

public class IniciarSesion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogInABM abmLogIn = new LogInABM();
		
		String usuario = "Javier";
		String contrasenia = "javier92";
		
		try {
			Personal personal = abmLogIn.iniciarSesion(usuario, contrasenia);
			System.out.println(personal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
