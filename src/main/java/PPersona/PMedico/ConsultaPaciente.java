package PPersona.PMedico;

import java.util.GregorianCalendar;

public class ConsultaPaciente {
	private GregorianCalendar fecha;
	private Medico medico;
	
	
	
	public ConsultaPaciente(GregorianCalendar fecha, Medico medico) {
		super();
		this.fecha = fecha;
		this.medico = medico;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public Medico getMedico() {
		return medico;
	}
	
	
	
	
}
