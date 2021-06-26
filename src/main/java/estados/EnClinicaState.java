package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;


/**
 * Esta clase se encarga de modelar el estado "EnClinicaState" de la ambulancia<br>
 * <b> Patrón aplicado: </b> State
 *
 * @author Los Cafeteros
 */



public class EnClinicaState implements IState {

	
	
	
	public EnClinicaState() {

	}

	@Override
	public void solicitaAtencionDomicilio() {
		Ambulancia.getInstance().setEstado(new AtendiendoPacienteState());
		Controlador.agregarSuceso("De la clinica --> Atender persona.paciente domicilio");
	}
	@Override
	public void solicitaTrasladoClinica() {
		Ambulancia.getInstance().setEstado(new TrasladoPacienteState());
		Controlador.agregarSuceso("De la clinica --> Va a buscar un persona.paciente para llevarlo a clinica");

	}

	@Override
	public void volverClinica() {
		Controlador.agregarSuceso("Se mantiene en la clinica");

	}

	@Override
	public void repararAmbulancia() {
		Ambulancia.getInstance().setEstado(new EnTallerState());
		Controlador.agregarSuceso("De la clinica --> Va al taller");


	}

	@Override
	public String estadoActual() {
		return "Disponible en la clinica";
	}
}
