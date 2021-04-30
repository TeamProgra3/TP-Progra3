package PPersona.PPacientes;

public class Nino extends Paciente {

	public Nino(String DNI, String nombre, String apellido) {
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
