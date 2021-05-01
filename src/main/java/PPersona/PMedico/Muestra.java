package PPersona.PMedico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import PClinica.ClinicaSingleton;

/**
 * @author Los cafeteros
 * Clase que tiene la responsabilidad de mostrar el reporte de actividad de un medico
 */
public class Muestra {
	
	public void reporteActividadDiaria2(int matricula,GregorianCalendar desde,GregorianCalendar hasta) {
		ArrayList<Consulta> aux = new ArrayList<Consulta>();
		ClinicaSingleton clinica=ClinicaSingleton.getInstance();
		Iterator<Consulta> it=clinica.buscaMedico(matricula).getConsultas().iterator();
		
		System.out.println("Consultas realizadas entre las fechas solicitadas:");
		while(it.hasNext() && it.next().getFecha().compareTo(desde)<=0)
			it.next();
		if(it.next().getFecha().compareTo(desde)>=0) {
			while(it.hasNext() && (it.next().getFecha().compareTo(hasta))<=0) {
				aux.add(it.next());
				System.out.println("Paciente:"+ clinica.buscaPaciente(it.next().getId()).getNombre() +"Fecha:"+it.next().getFecha() +"Honorario:"+clinica.buscaMedico(matricula).getHonorario());	
			}
			System.out.println("Cantidad de veces que fue atendido cada paciente");
			Map<Integer,Long> map=aux.stream().collect(Collectors.groupingBy(Consulta::getId,Collectors.counting()));
			for (Map.Entry<Integer,Long> entry : map.entrySet()) {
		        System.out.println("Paciente:"+ clinica.buscaPaciente(entry.getKey()).getNombre() + ":" + entry.getValue());
		    }
			
		}	
	}
}
