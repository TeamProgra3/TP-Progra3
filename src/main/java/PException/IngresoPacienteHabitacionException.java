package PException;

/**
 * Lanzada cuando no se pudo ingresar el paciente a la habitacion
 * @author Los Cafeteros
 *
 */
public class IngresoPacienteHabitacionException extends Exception{
	
	public IngresoPacienteHabitacionException(String mensajito) {
		super(mensajito);
	}
	
}
