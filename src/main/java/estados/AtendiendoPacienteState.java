package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;

/**
 * Esta clase se encarga de modelar el estado "AtiendePaciente" de la ambulancia<br>
 * <b> Patron aplicado: </b> State
 *
 * @author Los Cafeteros
 */


public class AtendiendoPacienteState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public void solicitaAtencionDomicilio() {
		Controlador.agregarSuceso("No puedo, ya estoy atendiendo a otra persona");
		

	}

	@Override
	public void solicitaTrasladoClinica() {
		Controlador.agregarSuceso("No puedo, estoy atendiendo a otra persona en domicilio");

	}

	@Override
	public void volverClinica() {
		ambulancia.setEstado(new RegresaLibreState());
		Controlador.agregarSuceso("Domicilio --> Regresando a clinica (Libre)");

	}
	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo, estoy atendiendo a otra persona en domicilio");

	}

	@Override
	public String estadoActual() {
		return "Atendiendo un paciente en domicilio";
	}

}
