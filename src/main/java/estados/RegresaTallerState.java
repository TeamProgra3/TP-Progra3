package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;

/**
 * Esta clase se encarga de modelar el estado "RegresaTallerState" de la ambulancia<br>
 * <b> Patrón aplicado: </b> State
 *
 * @author Los Cafeteros
 */


public class RegresaTallerState implements IState{

	
	@Override
	public void solicitaAtencionDomicilio() {
		Controlador.agregarSuceso("No puedo atender, estoy volviendo del taller");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		Controlador.agregarSuceso("No puedo atender, estoy volviendo del taller");
	}

	@Override
	public void volverClinica() {
		Ambulancia.getInstance().setEstado(new EnClinicaState());
		Controlador.agregarSuceso("Taller --> Clinica");
		
	}

	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo atender, estoy volviendo del taller");
	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica, reparaciones completas.";
	}

}
