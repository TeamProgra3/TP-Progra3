package persona.paciente;

/**
 * 
 * Esta clase hereda de la clase abstract Paciente, su implementacion corresponde a uno de los grupos etarios <br>
 * <b> Patr�n aplicado: </b> Double Dispatch.
 * @author Los Cafeteros
 *
 */
public class Joven extends Paciente {
	public Joven(int DNI, String nombre, String apellido) {
		super(DNI, nombre, apellido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean tienePrioridad(Paciente p) {
		return p.prioridadJoven();
	}

	@Override
	protected boolean prioridadMayor() {
		return true;
	}

	@Override
	protected boolean prioridadJoven() {
		return false;
	}

	@Override
	protected boolean prioridadNino() {
		return false;
	}

}
