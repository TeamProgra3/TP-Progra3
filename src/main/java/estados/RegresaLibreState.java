package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;


/**
 * Esta clase se encarga de modelar el estado "RegresaLibreState" de la ambulancia<br>
 * <b> Patron aplicado: </b> State
 *
 * @author Los Cafeteros
 */

public class RegresaLibreState implements IState {
	@Override
	public void solicitaAtencionDomicilio() {
        Ambulancia.getInstance().setEstado(new AtendiendoPacienteState());
		Controlador.agregarSuceso("Regresando --> Atender a domicilio paciente");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		Ambulancia.getInstance().setEstado(new TrasladoPacienteState());
		Controlador.agregarSuceso("Regresando --> Pasa a buscar a paciente");
	}

	@Override
	public void volverClinica() {
        Ambulancia.getInstance().setEstado(new EnClinicaState());
		Controlador.agregarSuceso("Regresando --> Llego a la clinica");
	}

	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo ir a taller, debo volver a clinica antes");

	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica sin paciente";
	}

}
