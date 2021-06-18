package estados;

import concurrencia.Ambulancia;

public class TrasladoPacienteState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public void solicitaAtencionDomicilio() {
		System.out.println("No puedo atender, estoy trasladando paciente");
	}

	@Override
	public void solicitaTrasladoClinica() {
		System.out.println("No puedo atender, estoy trasladando paciente");
	}

	@Override
	public void volverClinica() {
		ambulancia.setEstado(new EnClinicaState());
		System.out.println("Traslado --> Llegó a clinica");
	}

	@Override
	public void repararAmbulancia() {
		System.out.println("No puedo atender, estoy trasladando paciente");
	}

	@Override
	public String estadoActual() {
		return "Transladando paciente a la clinica";
	}

}
