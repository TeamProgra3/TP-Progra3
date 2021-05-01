package PModulos;

import PClinica.ClinicaSingleton;
import PPersona.PPacientes.Paciente;

/**
 *  @author Los Cafeteros <br>
 *  Este modulo se encarga de ingresar al paciente, sus responsabilidades son: <br>
 *  Asignar numero de orden al paciente <br>
 *  Resolver conflictos en la sala de espera privada y el patio <br>
 *  Cargar al paciente en los registros de la clinica <br>
 */
public class ModuloIngreso {
	public void ingresarPaciente(Paciente ingresante) {
		ClinicaSingleton clinica = ClinicaSingleton.getInstance();
    	if (clinica.getSalaPrivada() == null)
    		clinica.setSalaPrivada(ingresante);
    	else { //Resolver conflicto Double Dispatch
    		if (clinica.getSalaPrivada().tienePrioridad(ingresante)) { 
    		//Verifica si el ingresante tiene prioridad frente a quien ya estaba de antes
    		clinica.addPatio(clinica.getSalaPrivada());
    		clinica.setSalaPrivada(ingresante);
    		}
    		else {
    			clinica.addPatio(ingresante);
    		}
    	}
    }
	
}
