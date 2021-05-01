package PPersona.PPacientes;

/**
 * @author Los Cafeteros
 *  <br>
 * Esta clase hereda de la clase abstract Paciente, su implementacion corresponde a uno de los grupos etarios <br>
 * <b> Patrón aplicado: </b> Double Dispatch.
 *
 */

public class Mayor extends Paciente {

	public Mayor(String DNI, String nombre, String apellido, String rangoEtario) {
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
