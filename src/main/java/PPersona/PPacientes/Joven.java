package PPersona.PPacientes;

public class Joven extends Paciente {
	public Joven(String DNI, String nombre, String apellido) {
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
