/*package estados;

import concurrencia.Ambulancia;

public class EnTallerState implements IState{
	Ambulancia ambulancia = Ambulancia.getInstance();

	@Override
	public boolean solicitaAtencionDomicilio() {
		System.out.println("No puedo, en reparaciones");
		
	}

	@Override
	public boolean solicitaTrasladoClinica() {
		System.out.println("No puedo, en reparaciones");
		
	}

	@Override
	public boolean volverClinica() {
		ambulancia.setEstado(new RegresaTallerState());
		System.out.println("Regresando a la clinica tras finalizar reparaciones");
	}

	@Override
	public boolean repararAmbulancia() {
		System.out.println("No puedo, en reparaciones");
		
	}

	@Override
	public String estadoActual() {
		return "En reparacion en el taller";
	}

}
*/