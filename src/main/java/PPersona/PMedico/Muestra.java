package PPersona.PMedico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import PClinica.ClinicaSingleton;

/**
 * @author Los cafeteros
 * Clase que tiene la responsabilidad de mostrar el reporte de actividad de un medico
 */
public class Muestra {
	
	private ArrayList<MuestraAuxiliar> aux = new ArrayList<MuestraAuxiliar>();

	
	private class MuestraAuxiliar {
		public int id;
		public int cont;
		public MuestraAuxiliar(int id, int cont) {
			super();
			this.id = id;
			this.cont = cont;
		}
		public int getPaciente() {
			return id;
		}
		public int getCont() {
			return cont;
		}
		public void incrementa() {
			this.cont++;
		}

	}


	public void reporteActividadDiaria2(int matricula,GregorianCalendar desde,GregorianCalendar hasta) {
		MuestraAuxiliar aux1;
		ClinicaSingleton clinica=ClinicaSingleton.getInstance();
		
	    //private HashMap<Integer,Paciente> pacientesRegistrados =new HashMap<Integer, Paciente>();
	    //private HashMap<Integer, IMedico> medicos=new HashMap<Integer, IMedico>();
		
		Iterator<Consulta> it=clinica.buscaMedico(matricula).getConsultas().iterator();
		
		while(it.hasNext() && it.next().getFecha().compareTo(desde)<=0)
			it.next();
		if(it.next().getFecha().compareTo(desde)>=0) {
			while(it.hasNext() && (it.next().getFecha().compareTo(hasta))<=0) {
				
				if(aux.size()==0 || !aux.contains(it.next().getId())) //si no existe el paciente en la lista aux o esta vacia
					aux.add(new MuestraAuxiliar(it.next().getId(),0));
				else {
					aux1=aux.get( aux.indexOf(it.next().getId()));
					aux1.incrementa();
				}
				System.out.println("Paciente:"+ clinica.buscaPaciente(it.next().getId()).getNombre() +"Fecha:"+it.next().getFecha() );	
			}
			Iterator<MuestraAuxiliar> it2=aux.iterator();
			while(it2.hasNext()) {
				System.out.println("Paciente:"+clinica.buscaPaciente(it2.next().getPaciente()).getNombre()+" fue atendido "+it2.next().getCont()+"veces" );
			}
		}	
	}
	
	

	
	/*
	public void reporteActividadDiaria(Medico medico,GregorianCalendar desde,GregorianCalendar hasta) {
		totalConsultas=0;
		MuestraAuxiliar aux1;
		
		Iterator<Consulta> it=medico.consultas.iterator();
		
		while(it.hasNext() && it.next().getFecha().compareTo(desde)<=0)
			it.next();
		if(it.next().getFecha().compareTo(desde)>=0) {
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
			Iterator<MuestraAuxiliar> it2=aux.iterator();
			while(it2.hasNext()) {
				System.out.println("Paciente:"+it2.next().getPaciente().getApellido()+" fue atendido "+it2.next().getCont()+"veces" );
			}
			
			
		}
		System.out.println("Total de pacientes en el periodo:"+totalConsultas);
	}
	
*/
}
