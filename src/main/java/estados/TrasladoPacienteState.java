package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;


/**
 * Esta clase se encarga de modelar el estado "TrasladoPacienteState" de la ambulancia<br>
 * <b> Patron aplicado: </b> State
 *
 * @author Los Cafeteros
 */


public class TrasladoPacienteState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public void solicitaAtencionDomicilio() {
		Controlador.agregarSuceso("No puedo atender, estoy trasladando un paciente");
	}

	@Override
	public void solicitaTrasladoClinica() {
		Controlador.agregarSuceso("No puedo atender, estoy trasladando un paciente");
	}

	@Override
	public void volverClinica() {
		ambulancia.setEstado(new EnClinicaState());
		Controlador.agregarSuceso("Traslado --> Llego a clinica");
	}

	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo atender, estoy trasladando un paciente");
	}

	@Override
	public String estadoActual() {
		return "Transladando paciente a la clinica";
	}

}
