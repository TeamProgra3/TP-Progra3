package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;

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
