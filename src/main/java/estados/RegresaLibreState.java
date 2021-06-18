package estados;

import concurrencia.Ambulancia;

public class RegresaLibreState implements IState {
	@Override
	public void solicitaAtencionDomicilio() {
        Ambulancia.getInstance().setEstado(new AtendiendoPacienteState());
		System.out.println("Regresando --> Atender al domicilio paciente");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		Ambulancia.getInstance().setEstado(new TrasladoPacienteState());
		System.out.println("Regresando --> Pasa a buscar paciente");
	}

	@Override
	public void volverClinica() {
        Ambulancia.getInstance().setEstado(new EnClinicaState());
		System.out.println("Regresando --> Llego a la clinica");
	}

	@Override
	public void repararAmbulancia() {
		System.out.println("No puedo ir a taller, debo volver a clinica antes");

	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica sin paciente";
	}

}
