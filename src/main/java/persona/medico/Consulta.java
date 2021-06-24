package persona.medico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;



/**
 * 
 * Clase que almacena la fecha y el codigo que pueden pertenecer tanto a un persona.paciente, como a un persona.medico
 * @author Los cafeteros
 */
public class Consulta implements Comparable<Consulta>, Serializable {
	private GregorianCalendar fecha;
	private int id;
	private int cantDias;

	public Consulta(GregorianCalendar fecha, int id) {
		super();
		this.fecha = fecha;
		this.id=id;
	}
	public Consulta(GregorianCalendar fecha, int id,int dias){
		super();
		this.fecha = fecha;
		this.id=id;
		this.cantDias=dias;
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

	public int getDias(){
		return this.cantDias;
	}

	//array del persona.paciente -> [fecha | matricula persona.medico ]
	//array del persona.medico -> [fech | id hist clinica del persona.paciente]

	public void algo(){
	ArrayList<Consulta> aux=new ArrayList<>();
		Collections.sort(aux);
	}
}
