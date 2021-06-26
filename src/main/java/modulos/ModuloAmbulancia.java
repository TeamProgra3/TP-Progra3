package modulos;

import java.util.ArrayList;

import clinica.ClinicaSingleton;
import concurrencia.Asociado;
import concurrencia.ChoferAmbulancia;
import concurrencia.Operario;
import exception.AsociadoExistenteException;

/**
 * Esta clase es el encargado de manejar la simulacion, da inicio a todos los hilos (asociados,operario y chofer)<br>
 *
 *
 * @author Los Cafeteros
 */


public class ModuloAmbulancia {

	public static void iniciarSimulacion() {
		
		Operario operario =new Operario("Operario");
		operario.start();
		
		ArrayList<Asociado> lista = ClinicaSingleton.getInstance().getListaAsociados();
		for (Asociado asociado : lista) 
                    asociado.start();
		
		ChoferAmbulancia choferAmbulancia= new ChoferAmbulancia("Chofer","","","","99999999");
		choferAmbulancia.start();
		
	}
	
	public static void cargaRapida() {

		try {
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Leonel","Guccione","1","","1","TRASLADO"));
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Guillermo","Lazurri","2","","2","DOMICILIO"));
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Ivonne","Gellon","3","","3","TRASLADO"));
			ClinicaSingleton.getInstance().addAsociado(new Asociado("Ximena","","1","","4","DOMICILIO"));
		} catch (AsociadoExistenteException e) {
			e.printStackTrace();
		}

	}
}
