/*package estados;

import concurrencia.Ambulancia;

public class RegresaTallerState implements IState{
	Ambulancia ambulancia = Ambulancia.getInstance();
	
	@Override
	public boolean solicitaAtencionDomicilio() {
		System.out.println("No puedo atender, estoy volviendo del taller");
		
	}

	@Override
	public boolean solicitaTrasladoClinica() {
		System.out.println("No puedo atender, estoy volviendo del taller");
	}

	@Override
	public boolean volverClinica() {
		ambulancia.setEstado(new EnClinicaState());
		System.out.println("Taller --> Clinica");
		
	}

	@Override
	public boolean repararAmbulancia() {
		System.out.println("No puedo atender, estoy volviendo del taller");
	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica, reparaciones completas.";
	}

}
*/