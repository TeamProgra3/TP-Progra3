package PModulos;

import PClinica.ClinicaSingleton;
import PPersona.PPacientes.Paciente;
import PPersona.PPacientes.PacienteFactory;

/**
 * @author Los Cafeteros <br>
 *         Este modulo se encarga de ingresar al paciente, sus responsabilidades
 *         son: <br>
 *         Asignar numero de orden al paciente <br>
 *         Resolver conflictos en la sala de espera privada y el patio <br>
 *         Cargar al paciente en los registros de la clinica <br>
 */
public class ModuloIngreso {
	private static int nroOrden=0;

	public void ingresarPaciente(String nombre, String apellido, int DNI, String rangoEtario) {

		ClinicaSingleton clinica = ClinicaSingleton.getInstance();
		Paciente ingresante = clinica.buscaPaciente(DNI);
		if (ingresante == null) {
			PacienteFactory pfactory = new PacienteFactory();
			ingresante = pfactory.getPaciente(nombre, apellido, DNI, rangoEtario);
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
