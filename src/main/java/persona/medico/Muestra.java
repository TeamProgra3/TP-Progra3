package persona.medico;

import clinica.ClinicaSingleton;
import exception.NoHayPacienteException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * Clase que tiene la responsabilidad de mostrar el reporte de actividad de un persona.medico<br>
 * @author Los cafeteros
 */
public class Muestra {
	
	/**
	 * Metodo que muestra las consultas realizadas a un persona.medico determinado en un intervalo de tiempo determinado por dos paramentros. Este metodo tambien muestra cuantas veces atendio a cada persona.paciente en el intervalo de tiempo especificado.
	 * @param matricula - Matricula del persona.medico.
	 * @param desde - Fecha desde donde se comienzan a mostrar las consultas
	 * @param hasta - Fecha limite de muestra de consultas
	 * @throws NoHayPacienteException - Cuando no existe paciente
	 */
	public void reporteActividadDiaria2(int matricula,GregorianCalendar desde,GregorianCalendar hasta) throws NoHayPacienteException {
		int i=0;
		ClinicaSingleton clinica=ClinicaSingleton.getInstance();
		ArrayList<Consulta> aux = new ArrayList<Consulta>();
		ArrayList<Consulta> arrayAux=clinica.buscaMedico(matricula).getConsultas();
		
		if(arrayAux.size()==0)
			throw new NoHayPacienteException("El persona.medico no atendio ningun persona.paciente");
		System.out.println("Consultas realizadas entre las fechas solicitadas:");
		while( i<=arrayAux.size() && arrayAux.get(i).getFecha().compareTo(desde)<=0)
			i++;
		if(i<=arrayAux.size()) {
			while(i<arrayAux.size() && arrayAux.get(i).getFecha().compareTo(hasta)<=0) {
				aux.add(arrayAux.get(i));
				GregorianCalendar fechaAux=arrayAux.get(i).getFecha();
				System.out.println("Paciente: "+ clinica.buscaPacienteID(arrayAux.get(i).getId()).toString()+"  |   Fecha:"+fechaAux.get(Calendar.DAY_OF_MONTH)+"/"+ fechaAux.get(Calendar.MONTH)  +"/"+fechaAux.get(Calendar.YEAR)+"   | Honorario:"+clinica.buscaMedico(matricula).getHonorario());	
				i++;
			}
			System.out.println("Cantidad de veces que fue atendido cada persona.paciente:");
			Map<Integer,Long> map=aux.stream().collect(Collectors.groupingBy(Consulta::getId,Collectors.counting()));
			for (Map.Entry<Integer,Long> entry : map.entrySet()) {
		        System.out.println("Paciente: "+ clinica.buscaPacienteID(entry.getKey()).toString() + " : " + entry.getValue());
		    }
			
		}else
			System.out.println("No se realizaron consulta en el periodo de tiempo seleccionado");
	}
}
