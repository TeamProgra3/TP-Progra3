package estados;

import concurrencia.Ambulancia;

public class RegresaTallerState implements IState{

	
	@Override
	public void solicitaAtencionDomicilio() {
		System.out.println("No puedo atender, estoy volviendo del taller");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		System.out.println("No puedo atender, estoy volviendo del taller");
	}

	@Override
	public void volverClinica() {
		Ambulancia.getInstance().setEstado(new EnClinicaState());
		System.out.println("Taller --> Clinica");
		
	}

	@Override
	public void repararAmbulancia() {
		System.out.println("No puedo atender, estoy volviendo del taller");
	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica, reparaciones completas.";
	}

}
