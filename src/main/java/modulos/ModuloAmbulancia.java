package modulos;

import java.util.ArrayList;

import clinica.ClinicaSingleton;
import concurrencia.Asociado;
import concurrencia.Operario;

public class ModuloAmbulancia {

	public static void iniciarSimulacion() {
		int cantidad=0;
		Operario operario;
		ArrayList<Asociado> lista = ClinicaSingleton.getInstance().getListaAsociados();
		for (Asociado asociado : lista) {
			cantidad++;
			asociado.start();
		}
		operario = new Operario("Operario",cantidad);
		operario.start();
	}
	
	public static void cargaRapida() {

		ClinicaSingleton.getInstance().addAsociado(new Asociado("Leonel","Guccione","1","",""));
		ClinicaSingleton.getInstance().addAsociado(new Asociado("Guillermo","Lazurri","2","",""));
		ClinicaSingleton.getInstance().addAsociado(new Asociado("Ivonne","Gellon","3","",""));
		ClinicaSingleton.getInstance().addAsociado(new Asociado("Ximena","","1","",""));
		
	}
}
