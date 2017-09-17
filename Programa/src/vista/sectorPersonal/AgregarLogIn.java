package vista.sectorPersonal;

import negocio.sectorPersonal.LogInABM;

public class AgregarLogIn {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LogInABM abmLogIn = new LogInABM();
		try {
			int idLogIn = abmLogIn.agregarLogIn("Pablo", "pmouche");
			System.out.println("idLogIn: "+idLogIn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
