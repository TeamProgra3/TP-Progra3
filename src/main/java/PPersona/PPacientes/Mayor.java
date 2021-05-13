package PPersona.PPacientes;

/**
 * 
 * Esta clase hereda de la clase abstract Paciente, su implementacion corresponde a uno de los grupos etarios <br>
 * <b> Patrón aplicado: </b> Double Dispatch.
 * @author Los Cafeteros
 *
 */

public class Mayor extends Paciente {

	public Mayor(int DNI, String nombre, String apellido) {
		super(DNI, nombre, apellido);
	}

	@Override
	public boolean tienePrioridad(Paciente p) {
		return p.prioridadMayor();
	}

	@Override
	public boolean prioridadNino() {
		return true;
	}
	@Override
	public boolean prioridadJoven() {
		return false;
	}

	@Override
	protected boolean prioridadMayor() {
		return false;
	}
}
