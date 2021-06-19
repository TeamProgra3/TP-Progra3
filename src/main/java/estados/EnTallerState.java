package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;

public class EnTallerState implements IState{


	@Override
	public void solicitaAtencionDomicilio() {
		Controlador.agregarSuceso("No puedo, en reparaciones");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		Controlador.agregarSuceso("No puedo, en reparaciones");
		
	}

	@Override
	public void volverClinica() {
		Ambulancia.getInstance().setEstado(new RegresaTallerState());
		Controlador.agregarSuceso("Regresando a la clinica tras finalizar reparaciones");
	}

	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo, en reparaciones");
		
	}

	@Override
	public String estadoActual() {
		return "En reparacion en el taller";
	}

}