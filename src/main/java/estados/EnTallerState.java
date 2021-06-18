package estados;

import concurrencia.Ambulancia;

public class EnTallerState implements IState{


	@Override
	public void solicitaAtencionDomicilio() {
		System.out.println("No puedo, en reparaciones");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		System.out.println("No puedo, en reparaciones");
		
	}

	@Override
	public void volverClinica() {
		Ambulancia.getInstance().setEstado(new RegresaTallerState());
		System.out.println("Regresando a la clinica tras finalizar reparaciones");
	}

	@Override
	public void repararAmbulancia() {
		System.out.println("No puedo, en reparaciones");
		
	}

	@Override
	public String estadoActual() {
		return "En reparacion en el taller";
	}

}