package modulos;

import clinica.ClinicaSingleton;
import persona.paciente.Paciente;
import persona.paciente.PacienteFactory;

/**
 * 
 *         Este modulo se encarga de ingresar al persona.paciente, sus responsabilidades<br>
 *         son: <br>
 *         Asignar numero de orden al persona.paciente <br>
 *         Resolver conflictos en la sala de espera privada y el patio <br>
 *         Cargar al persona.paciente en los registros de la clinica <br>
 *         @author Los Cafeteros 
 */
public class ModuloIngreso {
	private static int nroOrden=0;

	/**
	 * Coloca un persona.paciente en espera,resuelve conflictos del lugar de espera
	 * @param nombre: Nombre del persona.paciente
	 * @param apellido: Apellido del persona.paciente
	 * @param DNI: DNI del persona.paciente
	 * @param rangoEtario: Rango etario del pacientes
	 */
	public void ingresarPaciente(String nombre, String apellido, int DNI, String rangoEtario) {

		ClinicaSingleton clinica = ClinicaSingleton.getInstance();
		Paciente ingresante = clinica.buscaPaciente(DNI);
		if (ingresante == null) {
			PacienteFactory pfactory = new PacienteFactory();
			ingresante = pfactory.getPaciente(nombre, apellido, DNI, rangoEtario);
			clinica.addPacienteRegistrado(ingresante);
		}
		ingresante.setNroOrden(this.getNroOrden());
		if (clinica.getSalaPrivada() == null)
			clinica.setSalaPrivada(ingresante);
		else { // Resolver conflicto Double Dispatch
			if (clinica.getSalaPrivada().tienePrioridad(ingresante)) {
				// Verifica si el ingresante tiene prioridad frente a quien ya estaba de antes
				clinica.addPatio(clinica.getSalaPrivada());
				clinica.setSalaPrivada(ingresante);
			} else {
				clinica.addPatio(ingresante);
			}
		}
	}
	
	public int getNroOrden() {
		int aux = ModuloIngreso.nroOrden;
		ModuloIngreso.nroOrden++;
		return aux;
	}
}
