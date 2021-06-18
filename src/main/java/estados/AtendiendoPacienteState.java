package estados;

import concurrencia.Ambulancia;

public class AtendiendoPacienteState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public void solicitaAtencionDomicilio() {
		System.out.println("No puedo, ya estoy atendiendo a otra persona");

	}

	@Override
	public void solicitaTrasladoClinica() {
		System.out.println("No puedo, estoy atendiendo a otra persona en domicilio");

	}

	@Override
	public void volverClinica() {
		ambulancia.setEstado(new EnClinicaState()); //TODO DEBERIA SER REGRESA LIBRE
		System.out.println("Domicilio --> Regresando a clinica (Libre)");

	}
	//TODO DESCOMENTAR
	@Override
	public void repararAmbulancia() {
		System.out.println("No puedo, estoy atendiendo a otra persona en domicilio");

	}

	@Override
	public String estadoActual() {
		return "Atendiendo un paciente en domicilio";
	}

}
