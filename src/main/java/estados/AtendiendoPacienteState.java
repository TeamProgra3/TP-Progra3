package estados;

import concurrencia.Ambulancia;

public class AtendiendoPacienteState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public boolean solicitaAtencionDomicilio() {
		System.out.println("No puedo, ya estoy atendiendo a otra persona");
		return false;
	}

	@Override
	public boolean solicitaTrasladoClinica() {
		System.out.println("No puedo, estoy atendiendo a otra persona en domicilio");
		return false;
	}

	@Override
	public boolean volverAClinica() { 
		ambulancia.setEstado(new EnClinicaState()); //TODO DEBERIA SER REGRESA LIBRE
		System.out.println("Domicilio --> Regresando a clinica (Libre)");
		return true;
	}
	//TODO DESCOMENTAR
	@Override
	public boolean repararAmbulancia() {
		System.out.println("No puedo, estoy atendiendo a otra persona en domicilio");
		return false;
	}

	@Override
	public String estadoActual() {
		return "Atendiendo un paciente en domicilio";
	}

}
