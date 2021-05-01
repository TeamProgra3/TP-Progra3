package PPersona.PMedico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;

import PPersona.PPacientes.Paciente;

/**
 * @author Los cafeteros<br>
 * Clase que almacena la fecha y el codigo que pueden pertenecer tanto a un paciente, como a un medico
 */
public class Consulta implements Comparable<Consulta>{
	private GregorianCalendar fecha;
	private int id;
		
	public Consulta(GregorianCalendar fecha, int id) {
		super();
		this.fecha = fecha;
		this.id=id;
	}

	public int getId() {
		return this.id;
	}

	public GregorianCalendar getFecha() {
		return this.fecha;
	}

	@Override
	public int compareTo(Consulta o) {
		if (o.getId()>id)
			return -1;
		else if(o.getId()>id){
			return 0;
		} else
			return 1;
	}


	//array del paciente -> [fecha | matricula medico ]
	//array del medico -> [fech | id hist clinica del paciente]

	public void algo(){
	ArrayList<Consulta> aux=new ArrayList<>();
		Collections.sort(aux);
	}
}
