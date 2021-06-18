package concurrencia;

import estados.EnClinicaState;
import estados.IState;

public class Ambulancia {
	private static Ambulancia instance=null;
	IState estado;
	
	private Ambulancia () {
		estado = new EnClinicaState();
	}
	
	public static Ambulancia getInstance() {
		if (instance == null)
			instance = new Ambulancia();
		return instance;
	}

	public IState getEstado() {
		return estado;
	}

	public void setEstado(IState estado) {
		this.estado = estado;
	}
}
