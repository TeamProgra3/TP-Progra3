package PModulos;

import java.util.ArrayList;

import PClinica.ClinicaSingleton;
import PException.EsperaVaciaException;
import PPersona.PPacientes.Paciente;

/**
 * Modulo que se  encarga de atender paciente retirandolo del lugar de espera y ubicandolo en atencion
 * 
 * @author Los cafeteros
 *
 */
public class ModuloAtencion {	
	ClinicaSingleton clinica= ClinicaSingleton.getInstance();
	
	/**
	 * Ejecuta la funcion del modulo considerando excepciones
	 * @throws EsperaVaciaException Excepcion lanzada cuando no hay paciente para atender
	 */
	public void retiraPaciente() throws EsperaVaciaException {
		ArrayList<Paciente> pacientes=clinica.getPatio();
		Paciente p=clinica.getSalaPrivada();
		
		if( p==null && pacientes.get(0)==null ) 
			throw new EsperaVaciaException("No hay gente para atender");
		if(p!=null) { 
			if(pacientes.get(0)==null || p.getNroOrden()<pacientes.get(0).getNroOrden()) {
				clinica.agregarPacienteListaAtencion(p);
				clinica.setSalaPrivada(null);
			}else {
				clinica.agregarPacienteListaAtencion(pacientes.get(0));
				pacientes.remove(0);
			}
		}else {
			clinica.agregarPacienteListaAtencion(pacientes.get(0));
			pacientes.remove(0);
		}
	}
}
