package estados;

import concurrencia.Ambulancia;

public class EnClinicaState implements IState {

	
	
	
	public EnClinicaState() {

	}

	@Override
	public boolean solicitaAtencionDomicilio() {
		Ambulancia.getInstance().setEstado(new AtendiendoPacienteState());
		System.out.println("De la clinica --> Atender paciente domicilio");
		return true;
	}

	@Override
	public boolean solicitaTrasladoClinica() {
		//ambulancia.setEstado(new TrasladoPacienteState()); TODO
		System.out.println("De la clinica --> Va a buscar un paciente para llevarlo a clinica");
		return true;
	}

	@Override
	public boolean volverAClinica() {
		System.out.println("Se mantiene en la clinica");
		return false; //TODO Revisar
	}

	@Override
	public boolean repararAmbulancia() {
		//ambulancia.setEstado(new EnTallerState()); TODO
		System.out.println("De la clinica --> Va al taller");
		return true;

	}

	@Override
	public String estadoActual() {
		return "Disponible en la clinica";
	}
}
