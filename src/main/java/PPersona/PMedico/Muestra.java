package PPersona.PMedico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import PClinica.ClinicaSingleton;

/**
 * 
 * Clase que tiene la responsabilidad de mostrar el reporte de actividad de un medico<br>
 * @author Los cafeteros
 */
public class Muestra {
	
	/**
	 * Metodo que muestra las consultas realizadas a un medico determinado en un intervalo de tiempo determinado por dos paramentros. Este metodo tambien muestra cuantas veces atendio a cada paciente en el intervalo de tiempo especificado.
	 * @param matricula - Matricula del medico.
	 * @param desde - Fecha desde donde se comienzan a mostrar las consultas
	 * @param hasta - Fecha limite de muestra de consultas
	 */
	public void reporteActividadDiaria2(int matricula,GregorianCalendar desde,GregorianCalendar hasta) {
		ArrayList<Consulta> aux = new ArrayList<Consulta>();
		ClinicaSingleton clinica=ClinicaSingleton.getInstance();
		//Iterator<Consulta> it=arrayAux.iterator();
		int i=0;
		ArrayList<Consulta> arrayAux=clinica.buscaMedico(matricula).getConsultas();
		
		System.out.println("Consultas realizadas entre las fechas solicitadas:");
		while( i<=arrayAux.size() && arrayAux.get(i).getFecha().compareTo(desde)<=0)
			i++;
		if(i<=arrayAux.size()) {
			while(i<arrayAux.size() && arrayAux.get(i).getFecha().compareTo(hasta)<=0) {
				aux.add(arrayAux.get(i));
				System.out.println("Paciente:"+ arrayAux.get(i).getId() +"  |   Fecha:"+arrayAux.get(i).getFecha() +"   | Honorario:"+clinica.buscaMedico(matricula).getHonorario());	
				i++;
			}
			System.out.println("Cantidad de veces que fue atendido cada paciente:");
			Map<Integer,Long> map=aux.stream().collect(Collectors.groupingBy(Consulta::getId,Collectors.counting()));
			for (Map.Entry<Integer,Long> entry : map.entrySet()) {
		        System.out.println("Paciente:"+ entry.getKey() + ":" + entry.getValue());
		    }
			
		}else
			System.out.println("Me cai xd");
	}
}
