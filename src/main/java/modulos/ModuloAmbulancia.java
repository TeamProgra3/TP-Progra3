package modulos;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;

import clinica.ClinicaSingleton;
import concurrencia.Asociado;
import concurrencia.ChoferAmbulancia;
import concurrencia.Operario;
import exception.AsociadoExistenteException;

public class ModuloAmbulancia {

	public static void iniciarSimulacion() {
		int cantidad=0;
		
		Operario operario =new Operario("Operario");
		operario.start();
		
		ArrayList<Asociado> lista = ClinicaSingleton.getInstance().getListaAsociados();
		for (Asociado asociado : lista) {
			cantidad++;
			asociado.start();
		}
		ChoferAmbulancia choferAmbulancia= new ChoferAmbulancia("Chofer",cantidad);
		choferAmbulancia.start();
		
	}
	
	public static void cargaRapida() {

		try {
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Leonel","Guccione","1","","1"));
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Guillermo","Lazurri","2","","2"));
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Ivonne","Gellon","3","","3"));
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Ximena","","1","","4"));
		} catch (AsociadoExistenteException e) {
			e.printStackTrace();
		}

	}
}
