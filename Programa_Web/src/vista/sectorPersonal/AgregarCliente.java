package vista.sectorPersonal;

import datos.sectorPersonal.TipoCliente;
import negocio.sectorPersonal.PersonaABM;
import negocio.sectorPersonal.TipoClienteABM;

public class AgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PersonaABM abmPersona = new PersonaABM();
			TipoClienteABM abmTipoCliente = new TipoClienteABM();

			String apellido = "Vescio";
			String nombre = "Javier";
			String dni = "36086446";
			TipoCliente tipoCliente = abmTipoCliente.traerTipoClientePorId(2);

			int idCliente = abmPersona.agregarCliente(apellido, nombre, dni, tipoCliente);
			System.out.println("idCliente agregado: " + idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
