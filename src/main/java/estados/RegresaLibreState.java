/*package estados;

import concurrencia.Ambulancia;

public class RegresaLibreState implements IState {
	Ambulancia ambulancia = Ambulancia.getInstance();
	@Override
	public boolean solicitaAtencionDomicilio() {
		ambulancia.setEstado(new AtendiendoPacienteState());
		System.out.println("Regresando --> Atender al domicilio paciente");
		
	}

	@Override
	public boolean solicitaTrasladoClinica() {
		ambulancia.setEstado(new TrasladoPacienteState());
		System.out.println("Regresando --> Pasa a buscar paciente");
	}

	@Override
	public boolean volverClinica() {
		ambulancia.setEstado(new EnClinicaState());
		System.out.println("Regresando --> Llego a la clinica");
	}

	@Override
	public boolean repararAmbulancia() {
		System.out.println("No puedo ir a taller, debo volver a clinica antes");

	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica sin paciente";
	}

}
*/