package paciente;


/**
 *
 *  
 * Esta clase hereda de la clase abstract Paciente, su implementacion corresponde a uno de los grupos etarios <br>
 * <b> Patrón aplicado: </b> Double Dispatch.<br>
 *  @author Los Cafeteros
 *
 */

public class Nino extends Paciente {

	public Nino(int DNI, String nombre, String apellido) {
		super(DNI, nombre, apellido);
	}

	@Override
	public boolean tienePrioridad(Paciente p) {
		return p.prioridadNino();
	}

	@Override
	protected boolean prioridadMayor() {
		return false;
	}

	@Override
	protected boolean prioridadJoven() {
		return true;
	}

	@Override
	protected boolean prioridadNino() {
		return false;
	}

}
