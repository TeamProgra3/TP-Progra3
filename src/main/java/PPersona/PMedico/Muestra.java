package PPersona.PMedico;

import PPersona.PPacientes.Paciente;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * @author Los cafeteros
 * Clase que tiene la responsabilidad de mostrar el reporte de actividad de un medico
 */
public class Muestra {
	
	private int totalConsultas;
	private ArrayList<MuestraAuxiliar> aux = new ArrayList<MuestraAuxiliar>();

	private class MuestraAuxiliar {
		public Paciente paciente;
		public int cont;



		public MuestraAuxiliar(Paciente paciente, int cont) {
			super();
			this.paciente = paciente;
			this.cont = cont;
		}

		public Paciente getPaciente() {
			return paciente;
		}



		public int getCont() {
			return cont;
		}

		public void incrementa() {
			this.cont++;
		}

	}

	
	
	
	/*public void reporteActividadDiaria(Medico medico,GregorianCalendar desde,GregorianCalendar hasta) {
		totalConsultas=0;
		MuestraAuxiliar aux1;
		
		Iterator<Consulta> it=medico.consultas.iterator();
		
		while(it.hasNext() && it.next().getFecha().compareTo(desde)<=0)
			it.next();
		if(it.next().getFecha().compareTo(desde)>=0) {
			//System.out.println("Listado de pacientes atendidos por:"+medico.apellido);
			while(it.hasNext() && (it.next().getFecha().compareTo(hasta))<=0) {
				
				
				if(aux.size()==0 || !aux.contains(it.next().getPaciente())) //si no existe el paciente en la lista aux o esta vacia
					aux.add(new MuestraAuxiliar(it.next().getPaciente(),0));
				else {
					aux1=aux.get( aux.indexOf(it.next().getPaciente()));
					aux1.incrementa();
				}
				System.out.println("Paciente:"+it.next().getPaciente().getApellido()+"Fecha:"+it.next().getFecha() );
				totalConsultas++;	
			}
			Listado();
		}
		System.out.println("Total de pacientes en el periodo:"+totalConsultas);
	}
	
	private void Listado() {
		
		Iterator<MuestraAuxiliar> it=aux.iterator();
		while(it.hasNext()) {
			System.out.println("Paciente:"+it.next().getPaciente().getApellido()+" fue atendido "+it.next().getCont()+"veces" );
		}
		
	}
		
	
*/
}
