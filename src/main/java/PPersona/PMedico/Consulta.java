package PPersona.PMedico;

import java.util.GregorianCalendar;

import PPersona.PPacientes.Paciente;

/**
 * @author Los cafeteros<br>
 * Clase que almacena la fecha y el codigo que pueden pertenecer tanto a un paciente, como a un medico
 */
public class Consulta {
	private GregorianCalendar fecha;
	private Paciente paciente;
		
	public Consulta(GregorianCalendar fecha, Paciente paciente) {
		super();
		this.fecha = fecha;
		this.paciente=paciente;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	

	
	//array del paciente -> [fecha | matricula medico ]
	//array del medico -> [fech | id hist clinica del paciente]
	
}
