package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;

/**
 * Esta clase se encarga de modelar el estado "EnTallerState" de la ambulancia<br>
 * <b> Patron aplicado: </b> State
 *
 * @author Los Cafeteros
 */


public class EnTallerState implements IState{


	@Override
	public void solicitaAtencionDomicilio() {
		Controlador.agregarSuceso("No puedo, en reparaciones");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		Controlador.agregarSuceso("No puedo, en reparaciones");
		
	}

	@Override
	public void volverClinica() {
		Ambulancia.getInstance().setEstado(new RegresaTallerState());
		Controlador.agregarSuceso("Regresando a la clinica tras finalizar reparaciones");
	}

	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo, en reparaciones");
		
	}

	@Override
	public String estadoActual() {
		return "En reparacion en el taller";
	}

}