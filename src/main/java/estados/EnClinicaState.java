package estados;

import concurrencia.Ambulancia;

public class EnClinicaState implements IState {

	
	
	
	public EnClinicaState() {

	}

	@Override
	public void solicitaAtencionDomicilio() {
		Ambulancia.getInstance().setEstado(new AtendiendoPacienteState());
		System.out.println("De la clinica --> Atender paciente domicilio");

	}

	@Override
	public void solicitaTrasladoClinica() {
		Ambulancia.getInstance().setEstado(new TrasladoPacienteState());
		System.out.println("De la clinica --> Va a buscar un paciente para llevarlo a clinica");

	}

	@Override
	public void volverClinica() {
		System.out.println("Se mantiene en la clinica");

	}

	@Override
	public void repararAmbulancia() {
		Ambulancia.getInstance().setEstado(new EnTallerState());
		System.out.println("De la clinica --> Va al taller");


	}

	@Override
	public String estadoActual() {
		return "Disponible en la clinica";
	}
}
