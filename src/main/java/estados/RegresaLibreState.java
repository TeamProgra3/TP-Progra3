package estados;

import concurrencia.Ambulancia;
import controlador.Controlador;

public class RegresaLibreState implements IState {
	@Override
	public void solicitaAtencionDomicilio() {
        Ambulancia.getInstance().setEstado(new AtendiendoPacienteState());
		Controlador.agregarSuceso("Regresando --> Atender al domicilio paciente");
		
	}

	@Override
	public void solicitaTrasladoClinica() {
		Ambulancia.getInstance().setEstado(new TrasladoPacienteState());
		Controlador.agregarSuceso("Regresando --> Pasa a buscar paciente");
	}

	@Override
	public void volverClinica() {
        Ambulancia.getInstance().setEstado(new EnClinicaState());
		Controlador.agregarSuceso("Regresando --> Llego a la clinica");
	}

	@Override
	public void repararAmbulancia() {
		Controlador.agregarSuceso("No puedo ir a taller, debo volver a clinica antes");

	}

	@Override
	public String estadoActual() {
		return "Regresando a la clinica sin paciente";
	}

}
