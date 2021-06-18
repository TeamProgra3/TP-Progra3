/*package estados;

import concurrencia.Ambulancia;

public class TrasladoPacienteState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public boolean solicitaAtencionDomicilio() {
		System.out.println("No puedo atender, estoy trasladando paciente");
	}

	@Override
	public boolean solicitaTrasladoClinica() {
		System.out.println("No puedo atender, estoy trasladando paciente");
	}

	@Override
	public boolean volverClinica() {
		ambulancia.setEstado(new EnClinicaState());
		System.out.println("Traslado --> Llegó a clinica");
	}

	@Override
	public boolean repararAmbulancia() {
		System.out.println("No puedo atender, estoy trasladando paciente");
	}

	@Override
	public String estadoActual() {
		return "Transladando paciente a la clinica";
	}

}*/
