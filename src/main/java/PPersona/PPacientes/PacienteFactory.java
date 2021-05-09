package PPersona.PPacientes;

public class PacienteFactory {
	public Paciente getPaciente(String nombre, String apellido, int DNI, String rangoEtario) {
		Paciente aux = null;
		if (rangoEtario.equalsIgnoreCase("JOVEN"))
			aux = new Joven(DNI, nombre, apellido);
		else if (rangoEtario.equalsIgnoreCase("MAYOR"))
			aux = new Mayor(DNI, nombre, apellido);
		else if (rangoEtario.equalsIgnoreCase("NINO"))
			aux = new Nino(DNI, nombre, apellido);
		return aux; 
	}
}
